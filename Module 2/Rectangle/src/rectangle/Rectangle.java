/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rectangle;

import java.util.Scanner;

/**
 *
 * @author PC STUDENT
 */
public class Rectangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float width, height;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter width: ");
        width = sc.nextFloat();
        
        System.out.println("Enter height: ");
        height = sc.nextFloat();
        
        float area = height * width;
        System.out.println("Area is: " + area);
    }
    
}
