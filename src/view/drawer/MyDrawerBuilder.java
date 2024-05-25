package view.drawer;

import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.MenuValidation;
import raven.drawer.component.menu.SimpleMenuOption;
import view.form.ConsumoForm;
import view.form.CadastroForm;
import application.main.Main;
import models.FuncionarioModel;
import raven.swing.AvatarIcon;
import view.tabbed.WindowsTabbed;

/**
 *
 * @author RAVEN
 */
public class MyDrawerBuilder extends SimpleDrawerBuilder {

    FuncionarioModel funcionario = Main.getFuncionario();
    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        return new SimpleHeaderData()
                .setIcon(new AvatarIcon(getClass().getResource("/view/image/profile.png"), 60, 60, 999))
                .setTitle(Main.funcionario.getNomeFuncionario())
                .setDescription(Main.funcionario.getEmailFuncionario());
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {
        String menus[][] = {
            {"~PRINCIPAL~"},
            {"Consumo"},
            {"Cliente", "Cadastro", "Consulta", "Atualizar"},
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
                            WindowsTabbed.getInstance().addTab("Cadastro", new CadastroForm());
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

    @Override
    public SimpleFooterData getSimpleFooterData() {
        return new SimpleFooterData()
                .setTitle("Java Swing Drawer")
                .setDescription("Version 1.1.0");
    }

    @Override
    public int getDrawerWidth() {
        return 275;
    }
}
