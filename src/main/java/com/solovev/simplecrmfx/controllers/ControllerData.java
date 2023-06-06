package com.solovev.simplecrmfx.controllers;
/**
 * Interface to pass objects to the controllers
 * @param <T>
 */

public interface ControllerData<T> {
    void initData(T data);
}
