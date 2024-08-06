
package com.pss.desafiodatabinding;

import com.pss.desafiodatabinding.binding.BindingManager;


public class DesafioDataBinding {

    public static void main(String[] args) {
        String model = "Initial data";
        String view = "Initial view";

        BindingManager bindingManager = new BindingManager(model, view);
        bindingManager.configureTwoWayBinding();

        // Update model
        bindingManager.updateModel("New model data");
        System.out.println("View after model update: " + view);

        // Update view
        bindingManager.updateView("New view data");
        System.out.println("Model after view update: " + model);
    }
}


