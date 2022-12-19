/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolhelp;

/**
 *
 * @author risak
 */
public class SchoolHELPGUI {
    
    public static SchoolHELP schoolHELP = new SchoolHELP();
    
    public static void main(String[] args) {
        schoolHELP.init();
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        
    }
}
