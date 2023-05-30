/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.PersonaJDBC;
import domain.Persona;

/**
 *
 * @author Rafa
 */
public class ManejoPersonas {
    
    public static void main(String[] args) {
        
        int rows=0;
        PersonaJDBC personaData = new PersonaJDBC();
        
        Persona persona=new Persona();
        persona.setNombre("Jose Fabian");
        persona.setApellido("Bolaño Herrera");
        persona.setEmail("fabian@mailinator.com");
        persona.setTelefono("301-2935386");
        
        rows = personaData.insert(persona);
        
        persona.setIdPersona(8);
        rows = personaData.update(persona);
        
        personaData.delete(2);
        
        var personas = personaData.select();
        
        for(Persona item: personas)
        {
            System.out.println("persona: " + item);
        }
        
    }
    
}
