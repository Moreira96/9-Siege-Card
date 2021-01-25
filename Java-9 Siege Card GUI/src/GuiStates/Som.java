/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiStates;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 *
 * @author morei
 */
public class Som {

    private AudioClip som;
    
    public Som(String pathnameRelativo) {
// newAudioClip() é um método estático da classe Applet;
// por ser estático pode invocar-se sem ser através dum objecto
// da classe (Applet); pode então servir
// para "carregar" um ficheiro de som numa aplicação;
// o argumento é o URL do ficheiro de som
//System.out.println(" " + pathnameRelativo);
        URL url = Resources.getResourceFile(pathnameRelativo);
        if (url != null) {
            som = Applet.newAudioClip(url);
        }
            
    }

    public boolean iniciar(boolean on) {
        if (som != null) {
            som.stop();
            som.play();
            on = true;
        }
        return on;
    }

    public boolean play(boolean on) {
        if (som != null && on == false) {
            som.play();
            on = true;
        }
        return on;
    }

    public boolean stop(boolean on) {
        if (som != null) {
            som.stop();
            on = false;
        }
        return on;
    }
    
    public void button(){
        if(som != null)
            som.play();
    }

    public boolean loop(boolean on) {
        if (som != null && on == false) {
            som.loop();
            on = true;
        }
        return on;
    }
}
