package view.drawer;

import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.MenuValidation;
import raven.drawer.component.menu.SimpleMenuOption;
import view.form.ConsumoForm;
import view.form.CadastroClienteForm;
import application.main.Main;
import controllers.Funcionario;
import raven.swing.AvatarIcon;
import view.form.CadastroLeituraForm;
import view.tabbed.WindowsTabbed;

/**
 *
 * @author RAVEN
 */
public class MyDrawerBuilder extends SimpleDrawerBuilder {

    Funcionario funcionario = Main.getFuncionario();
    
    /**
     * Método que define a cabeçalho do menu
     * @return - cabeçalho definido
     */
    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        return new SimpleHeaderData()
                .setIcon(new AvatarIcon(getClass().getResource("/view/image/profile.png"), 60, 60, 999))
                .setTitle("João Silva")
                .setDescription("joaosilva@gmail.com");
    }
    
    /**
     * Método que cria e define os itens do menu
     * @return - menu definido
     */
    @Override
    public SimpleMenuOption getSimpleMenuOption() {
        String menus[][] = {
            {"~PRINCIPAL~"},
            {"Consumo"},
            {"Consultas", "Cliente", "Leitura"},
            {"~OUTROS~"},
            {"Logout"}};

        String icons[] = {
            "chart.svg",
            "forms.svg",
            "logout.svg"};

        return new SimpleMenuOption()
                .setMenus(menus)
                .setIcons(icons)
                .setBaseIconPath("view/drawer/icon")
                .setIconScale(0.45f)
                .addMenuEvent(new MenuEvent() {
                    @Override
                    public void selected(MenuAction action, int index, int subIndex) {
                        if (index == 0) {
                            WindowsTabbed.getInstance().addTab("Consumo", new ConsumoForm());
                        }
                        else if (index == 1 && subIndex==1) {
                            WindowsTabbed.getInstance().addTab("Cadastro", new CadastroClienteForm());
                        }
                        else if(index == 1 && subIndex==2){
                            WindowsTabbed.getInstance().addTab("Cadastro", new CadastroLeituraForm());
                        }else if (index == 2) {
                            Main.main.login();
                        }
                        System.out.println("Menu selected " + index + " " + subIndex);
                    }
                })
                .setMenuValidation(new MenuValidation() {
                    @Override
                    public boolean menuValidation(int index, int subIndex) {
//                        if(index==0){
//                            return false;
//                        }else if(index==3){
//                            return false;
//                        }
                        return true;
                    }

                });
    }

    /**
     * Método que define o rodapé
     * @return - rodapé que foi definido
     */
    @Override
    public SimpleFooterData getSimpleFooterData() {
        return new SimpleFooterData()
                .setTitle("HidroViewer")
                .setDescription("Version 1.1.0");
    }
    
    /**
     * Método que define a largura do menu
     * @return 
     */
    @Override
    public int getDrawerWidth() {
        return 275;
    }
}
