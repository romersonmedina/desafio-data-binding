
package com.pss.desafiodatabinding.binding;


import com.pss.desafiodatabinding.observer.Observable;
import com.pss.desafiodatabinding.observer.Observer;

public class BindingManager {
   private Observable observable;
    private Object source;
    private Object target;
    private String sourceProperty;
    private String targetProperty;

    public BindingManager(Object source, Object target, String sourceProperty, String targetProperty) {
        this.source = source;
        this.target = target;
        this.sourceProperty = sourceProperty;
        this.targetProperty = targetProperty;
        this.observable = new Observable();
    }

    public void configureOneWayBinding(boolean sourceToTarget) {
        observable.addObserver(new Observer() {
            @Override
            public void update(Object data) {
                if (sourceToTarget) {
                    
                    setProperty(target, targetProperty, data);
                } else {
                    
                    setProperty(source, sourceProperty, data);
                }
            }
        });
    }

    public void configureTwoWayBinding() {
        observable.addObserver(new Observer() {
            @Override
            public void update(Object data) {
                
                setProperty(target, targetProperty, data);
            }
        });
        observable.addObserver(new Observer() {
            @Override
            public void update(Object data) {
                
                setProperty(source, sourceProperty, data);
            }
        });
    }

    public void updateSource(Object newValue) {
        setProperty(source, sourceProperty, newValue);
        observable.notifyObservers(newValue);
    }

    public void updateTarget(Object newValue) {
        setProperty(target, targetProperty, newValue);
        observable.notifyObservers(newValue);
    }

    private void setProperty(Object obj, String property, Object value) {
        try {
            var field = obj.getClass().getDeclaredField(property);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 }
