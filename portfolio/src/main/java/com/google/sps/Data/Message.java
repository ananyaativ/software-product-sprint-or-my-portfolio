package com.google.sps.Data;

/** An item on a todo list. */
public final class Message {

  private final String name;
  private final String email;
  private final String message;

  public Message(String name, String email, String message) {
    this.name = name;
    this.email = email;
    this.message = message;
  }
}