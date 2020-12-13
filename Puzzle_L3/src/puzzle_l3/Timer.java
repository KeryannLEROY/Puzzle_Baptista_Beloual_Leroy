/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

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
public class Timer implements Runnable
{    
    Thread thread;
    long previousDate;
    boolean running;
    double deltaT;
    double timeOut;
    double chrono;
    HashMap<Object,ArrayList<Method>> methods= new HashMap<>();
    
    /**
     *
     */
    public Timer()
    {
        timeOut=0;
        deltaT=0;
        running=false;
    }

    /**
     *
     * @param milliseconds
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
     *
     * @return
     */
    public boolean isRunning() 
    {
        return running;
    }

    /**
     *
     */
    public void onOffSwitch()
    {
        this.setRunning(!running);
    }

    /**
     *
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
     *
     */
    public void pause() 
    {
        this.running = false;
        thread=null;
    }

    /**
     *
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
     *
     * @return
     */
    public double getTimeOut() 
    {
        return timeOut;
    }

    /**
     *
     * @param milliseconds
     */
    public void setTimeOut(int milliseconds) 
    {
        this.setTimeOut(milliseconds/1000.0);
    }

    /**
     *
     * @param timeOut
     */
    public void setTimeOut(double timeOut) 
    {
        this.timeOut = timeOut<0?0:timeOut;
    }

    /**
     *
     * @param chrono
     */
    public void setChrono(double chrono) 
    {
        if(!running)
            this.chrono = chrono;
        else
            throw new UnsupportedOperationException("This method cannot be used unless the Timer is stopped.");
    }

    /**
     *
     * @return
     */
    public double getChrono() 
    {
        return chrono;
    }

    /**
     *
     */
    public void clearBehavior()
    {
        if(!running)
            methods.clear();
        else
            throw new UnsupportedOperationException("This method cannot be used unless the Timer is stopped.");
    }

    /**
     *
     * @param object
     */
    public void removeFromBehavior(Object object)
    {
        if(!running)
            methods.remove(object);
        else
            throw new UnsupportedOperationException("This method cannot be used unless the Timer is stopped.");
    }

    /**
     *
     * @param object
     * @param method
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
     *
     * @param deltaT
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
