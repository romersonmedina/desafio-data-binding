
package com.pss.desafiodatabinding.binding;


import com.pss.desafiodatabinding.observer.Observable;
import com.pss.desafiodatabinding.observer.Observer;

public class BindingManager {
    private Observable observable;
    private Object model;
    private Object view;

    public BindingManager(Object model, Object view) {
        this.model = model;
        this.view = view;
        this.observable = new Observable();
    }

    public void configureOneWayBinding(boolean modelToView) {
        observable.addObserver(new Observer() {
            @Override
            public void update(Object data) {
                if (modelToView) {
                    view = data;
                } else {
                    model = data;
                }
            }
        });
    }

    public void configureTwoWayBinding() {
        observable.addObserver(new Observer() {
            @Override
            public void update(Object data) {
                view = data;
            }
        });
        observable.addObserver(new Observer() {
            @Override
            public void update(Object data) {
                model = data;
            }
        });
    }

    public void updateModel(Object newModel) {
        model = newModel;
        observable.notifyObservers(model);
    }

    public void updateView(Object newView) {
        view = newView;
        observable.notifyObservers(view);
    }

 }
