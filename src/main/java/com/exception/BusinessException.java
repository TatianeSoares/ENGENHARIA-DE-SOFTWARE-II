package com.exception;

import java.io.Serializable;

public class BusinessException extends Exception implements Serializable {
  public BusinessException(String message) {
    super(message);
  }
}
