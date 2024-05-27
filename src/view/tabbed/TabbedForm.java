package view.tabbed;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JPanel;

/**
 *
 * @author RAVEN
 */
public class TabbedForm extends JPanel{
    
    public void init(){
            putClientProperty(FlatClientProperties.STYLE, ""
                + "border:5,5,5,5;"
                + "background:null");
    }
    public void formOpen(){
        
    }
    
    public boolean formClose(){
        return true;
    }
    
    public void fromRefresh(){
        //  Not yet work ( next update )
    }
}
