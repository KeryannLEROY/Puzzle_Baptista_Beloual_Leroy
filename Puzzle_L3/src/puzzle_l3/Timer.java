/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kerya
 */
public class Timer implements Runnable ,Serializable
{    
    //
    private Thread thread;
    private long previousDate;
    private boolean running;
    private double deltaT;
    private double timeOut;
    private double chrono;
    private HashMap<Object,ArrayList<Method>> methods= new HashMap<>();
    
    /**
     * Constructeur par défaut de la clase Timer
     */
    public Timer()
    {
        timeOut=0;
        deltaT=0;
        running=false;
    }

    /**
     * Constructeur de la clase Timer
     * @param milliseconds interval de temps en milliseconde entre deux rafraîchissement du timer.
     */
    public Timer(int milliseconds)
    {
        timeOut=(milliseconds<0?0:milliseconds)/1000.0;
        deltaT=0;
        chrono=0;
        running=false;
    }
    @Override
    public void run() 
    {
        
        while(running)
        {
            long now=System.nanoTime();
            deltaT+=(now-previousDate)*Math.pow(10, -9);
            previousDate=now;
            if(deltaT>=timeOut)
            {
                chrono+=deltaT;
                //System.out.println(deltaT);
                this.behavior(deltaT);

                
                deltaT=0;
            }
        }
    }

    /**
     * Retourne True si le Timer est en fonctionnement, sinon false.
     * @return booléen
     */
    public boolean isRunning() 
    {
        return running;
    }

    /**
     *  Démarre le timer si il est arrêté ou l'arrête s'il est en fonctionnement.
     */
    public void onOffSwitch()
    {
        this.setRunning(!running);
    }

    /**
     * si true est passer en parametre,Démarre le timer, sinon l'arrête.
     * @param running
     */
    public void setRunning(boolean running) 
    {
        if(running)
        {
            this.unPause();
        }
        else
        {
            this.pause();         
        }
    }

    /**
     * Arrête le Timer.
     */
    public void pause() 
    {
        this.running = false;
        thread=null;
    }

    /**
     * Démarre le Timer.
     */
    public void unPause() 
    {
        this.running = true;
        deltaT=0;
        previousDate=System.nanoTime();
        thread=new Thread(this);
        thread.start();
        
    }

    /**
     * Retourne interval de temps en seconde entre deux rafraîchissement du timer.
     * @return interval de temps en seconde
     */
    public double getTimeOut() 
    {
        return timeOut;
    }

    /**
     * Modificateur de l'interval de temps.
     * @param milliseconds interval de temps en milliseconde
     */
    public void setTimeOut(int milliseconds) 
    {
        this.setTimeOut(milliseconds/1000.0);
    }

    /**
     * Modificateur de l'interval de temps.
     * @param timeOut interval de temps en seconde
     */
    public void setTimeOut(double timeOut) 
    {
        this.timeOut = timeOut<0?0:timeOut;
    }

    /**
     * Modificateur du chronometre.
     * @param chrono temps en seconde.
     */
    public void setChrono(double chrono) 
    {
        if(!running)
            this.chrono = chrono;
        else
            throw new UnsupportedOperationException("This method cannot be used unless the Timer is stopped.");
    }

    /**
     * Accesseur du chronometre.
     * @return temps en seconde.
     */
    public double getChrono() 
    {
        return chrono;
    }

    /**
     * Vide la liste de méthode à éxecuter à chaque interval de temps.
     */
    public void clearBehavior()
    {
        if(!running)
            methods.clear();
        else
            throw new UnsupportedOperationException("This method cannot be used unless the Timer is stopped.");
    }

    /**
     * Retire toutes les méthode assosier à object. A utiliser pour que les object qui ne sont plus utile puissent être detruits.
     * @param object objet a supprimer
     */
    public void removeFromBehavior(Object object)
    {
        if(!running)
            methods.remove(object);
        else
            throw new UnsupportedOperationException("This method cannot be used unless the Timer is stopped.");
    }

    /**
     * Ajoute une méthode associer à un objet au methodes à éxecuter à chaque interval de temps.
     * Les méthode fournie doivent possèder un unique parametre de type double.
     * @param object objet qui execute la méthode.
     * @param method chaine de caracteres identifiant la méthode à éxecuter.
     */
    public void addToBehavior(Object object,String method)
    {
        method+=("(double)");
        boolean found=false;
        if(!running)
        {
            Method[]classMethods=object.getClass().getMethods();
            for (Method classMethod : classMethods) {
                
                if (classMethod.toGenericString().contains(method)) {
                    
                    
                    ArrayList<Method>currentMethods=methods.getOrDefault(object,new ArrayList<>());
                    currentMethods.add(classMethod);
                    methods.put(object, currentMethods);
                    found=true;
                    
                    
                    
                }
            }
            if(!found)
            throw new IllegalArgumentException("The method given must have exactly 1 parameter and its type must be double");

            
        }
        else
            throw new UnsupportedOperationException("This method cannot be used unless the Timer is stopped.");
    }

    /**
     * Methode qui execute toute les méthodes fournies au timer.
     * @param deltaT interval de temps qui sera passé en paramètre de toutes les méthodes.
     */
    protected void behavior(double deltaT)
    {
        class CallToMethods implements BiConsumer<Object, ArrayList<Method>>
        {

            @Override
            public void accept(Object object, ArrayList<Method> methodList) {
                for(int i=0;i<methodList.size();++i)
                {
                    try {
                        methodList.get(i).invoke(object, deltaT);
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                        Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } 
        }
        methods.forEach(new CallToMethods());
    }
    
    
}
