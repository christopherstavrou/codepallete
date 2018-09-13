/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmclinnovations.codepalette.basic_concepts;

/**
 *
 */
public class ExampleException extends Exception {

    /**
     * Creates a new instance of <code>ExampleException</code> without detail
     * message.
     */
    public ExampleException() {
    }

    /**
     * Constructs an instance of <code>ExampleException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExampleException(String msg) {
        super(msg);
    }
}
