/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadorjson;

/**
 *
 * @author pingu
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Controlador {
     String Cadenaentrada="This is an humilde prueba.";
    
    public Controlador(String cadena){
    Cadenaentrada=cadena;
    }


     public void inicio() {
    String json;
    System.setProperty("webdriver.chrome.driver","chromedriver.exe");
    
    try{
    WebDriver driver=new ChromeDriver();
    driver.get("https://rextester.com/live/HFLY52077?fbclid=IwAR3UoUqXm2Kg8cceW-9M24q7f12iasFRbICX5jb4DKpFXFhuh4lR2JjIn30");
   //Se le da tiempo a la página para cargar
    Thread.sleep(4000);
                                      
    try{
    WebElement entrada=driver.findElement(By.name("Input"));
    WebElement boton=driver.findElement(By.id("Run"));
   
  
    
    //Limpiamos la entrada
    entrada.clear();
    //Se escribirá
     System.out.println("Esto esta en la cadena: "+Cadenaentrada+"");
    //Escribimos la cadena
    entrada.sendKeys(Cadenaentrada+"");
    //Clic al botón de RUN
    boton.click();
    //Obtenemos la cadena generada
      WebElement resultado=driver.findElement(By.id("Result")); 
          //Demos un tiempo a que genere el resultado
    Thread.sleep(4000);
      json=resultado.getText();
      System.out.println(json);
              
              
              
   
              
              
     //Abrimos JSON validator
     driver.get("https://jsonformatter.curiousconcept.com/?fbclid=IwAR1A4ltr7AOiq7UgCdrFmjj6WJghSIn-Qka0dm4saWLrl-TnkrdlO9yxMW8");
     //Tiempo para que cargue la página
     Thread.sleep(4000);
     //Pegamos la cadena en Json
     WebElement enJs=driver.findElement(By.id("jsondata"));
     WebElement salJs=driver.findElement(By.id("process"));
     enJs.sendKeys(json+"");
     salJs.click();
     
     



    }
    catch(Exception e){
    System.out.println("Error de lectura, no se encuentra el elemento");

    
    }
    
    }
    catch(Exception E){
    System.out.println("Error de carga, la pagina no se encontró");
    
    }
    
    }
    
    
    
    
}
