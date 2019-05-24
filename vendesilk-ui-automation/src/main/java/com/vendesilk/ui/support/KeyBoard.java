package com.vendesilk.ui.support;


import com.vendesilk.ui.exception.FrameworkException;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyBoard
{
  private Robot robot;

  //final static Logger log = Logger.getLogger(KeyBoard.class);

  public static void main(String... args) throws FrameworkException {
    KeyBoard keyboard;
    try
    {
      keyboard = new KeyBoard();
      keyboard.type("Hello there, how are you?");
    }
    catch (Exception e)
    {
      throw new FrameworkException("Error ! Occured while during the robot initialization");
    }

  }

  public void typeText(String text)
  {
    this.type(text);
  }

  public KeyBoard() throws FrameworkException {
    try {
      this.robot = new Robot();
    }catch (Exception e){
      throw new FrameworkException("Error ! Occured while during the robot initialization");
    }
  }

  public KeyBoard(Robot robot)
  {
    this.robot = robot;
  }

  public void type(CharSequence characters)
  {
    int length = characters.length();
    for (int i = 0; i < length; i++)
    {
      char character = characters.charAt(i);
      type(character);
    }
  }

  public void type(char character)
  { // NOSONAR
    switch (character)
    {
      case 'a':
        doType(KeyEvent.VK_A);
        break;
      case 'b':
        doType(KeyEvent.VK_B);
        break;
      case 'c':
        doType(KeyEvent.VK_C);
        break;
      case 'd':
        doType(KeyEvent.VK_D);
        break;
      case 'e':
        doType(KeyEvent.VK_E);
        break;
      case 'f':
        doType(KeyEvent.VK_F);
        break;
      case 'g':
        doType(KeyEvent.VK_G);
        break;
      case 'h':
        doType(KeyEvent.VK_H);
        break;
      case 'i':
        doType(KeyEvent.VK_I);
        break;
      case 'j':
        doType(KeyEvent.VK_J);
        break;
      case 'k':
        doType(KeyEvent.VK_K);
        break;
      case 'l':
        doType(KeyEvent.VK_L);
        break;
      case 'm':
        doType(KeyEvent.VK_M);
        break;
      case 'n':
        doType(KeyEvent.VK_N);
        break;
      case 'o':
        doType(KeyEvent.VK_O);
        break;
      case 'p':
        doType(KeyEvent.VK_P);
        break;
      case 'q':
        doType(KeyEvent.VK_Q);
        break;
      case 'r':
        doType(KeyEvent.VK_R);
        break;
      case 's':
        doType(KeyEvent.VK_S);
        break;
      case 't':
        doType(KeyEvent.VK_T);
        break;
      case 'u':
        doType(KeyEvent.VK_U);
        break;
      case 'v':
        doType(KeyEvent.VK_V);
        break;
      case 'w':
        doType(KeyEvent.VK_W);
        break;
      case 'x':
        doType(KeyEvent.VK_X);
        break;
      case 'y':
        doType(KeyEvent.VK_Y);
        break;
      case 'z':
        doType(KeyEvent.VK_Z);
        break;
      case 'A':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_A);
        break;
      case 'B':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
        break;
      case 'C':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_C);
        break;
      case 'D':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_D);
        break;
      case 'E':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_E);
        break;
      case 'F':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_F);
        break;
      case 'G':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_G);
        break;
      case 'H':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_H);
        break;
      case 'I':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_I);
        break;
      case 'J':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_J);
        break;
      case 'K':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_K);
        break;
      case 'L':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_L);
        break;
      case 'M':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_M);
        break;
      case 'N':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_N);
        break;
      case 'O':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_O);
        break;
      case 'P':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_P);
        break;
      case 'Q':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Q);
        break;
      case 'R':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_R);
        break;
      case 'S':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_S);
        break;
      case 'T':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_T);
        break;
      case 'U':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_U);
        break;
      case 'V':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_V);
        break;
      case 'W':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_W);
        break;
      case 'X':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_X);
        break;
      case 'Y':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Y);
        break;
      case 'Z':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Z);
        break;
      case '`':
        doType(KeyEvent.VK_BACK_QUOTE);
        break;
      case '0':
        doType(KeyEvent.VK_0);
        break;
      case '1':
        doType(KeyEvent.VK_1);
        break;
      case '2':
        doType(KeyEvent.VK_2);
        break;
      case '3':
        doType(KeyEvent.VK_3);
        break;
      case '4':
        doType(KeyEvent.VK_4);
        break;
      case '5':
        doType(KeyEvent.VK_5);
        break;
      case '6':
        doType(KeyEvent.VK_6);
        break;
      case '7':
        doType(KeyEvent.VK_7);
        break;
      case '8':
        doType(KeyEvent.VK_8);
        break;
      case '9':
        doType(KeyEvent.VK_9);
        break;
      case '-':
        doType(KeyEvent.VK_MINUS);
        break;
      case '=':
        doType(KeyEvent.VK_EQUALS);
        break;
      case '~':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_QUOTE);
        break;
      case '!':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_1);
        break;
      case '@':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_2);
        break;
      case '#':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_3);
        break;
      case '$':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_4);
        break;
      case '%':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_5);
        break;
      case '^':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_6);
        break;
      case '&':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_7);
        break;
      case '*':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_8);
        break;
      case '(':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_9);
        break;
      case ')':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_0);
        break;
      case '_':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_MINUS);
        break;
      case '+':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_EQUALS);
        break;
      case '\t':
        doType(KeyEvent.VK_TAB);
        break;
      case '\n':
        doType(KeyEvent.VK_ENTER);
        break;
      case '[':
        doType(KeyEvent.VK_OPEN_BRACKET);
        break;
      case ']':
        doType(KeyEvent.VK_CLOSE_BRACKET);
        break;
      case '\\':
        doType(KeyEvent.VK_BACK_SLASH);
        break;
      case '{':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_OPEN_BRACKET);
        break;
      case '}':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_CLOSE_BRACKET);
        break;
      case '|':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_SLASH);
        break;
      case ';':
        doType(KeyEvent.VK_SEMICOLON);
        break;
      case ':':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_SEMICOLON);
        break;
      case '\'':
        doType(KeyEvent.VK_QUOTE);
        break;
      case '"':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_QUOTE);
        break;
      case ',':
        doType(KeyEvent.VK_COMMA);
        break;
      case '<':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_COMMA);
        break;
      case '.':
        doType(KeyEvent.VK_PERIOD);
        break;
      case '>':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_PERIOD);
        break;
      case '/':
        doType(KeyEvent.VK_SLASH);
        break;
      case '?':
        doType(KeyEvent.VK_SHIFT, KeyEvent.VK_SLASH);
        break;
      case ' ':
        doType(KeyEvent.VK_SPACE);
        break;
      default:
        throw new IllegalArgumentException("Cannot type character " + character);
    }
  }

  private void doType(int... keyCodes)
  {
    doType(keyCodes, 0, keyCodes.length);
  }

  private void doType(int[] keyCodes, int offset, int length)
  {
    if (length == 0)
    {
      return;
    }

    robot.keyPress(keyCodes[offset]);
    doType(keyCodes, offset + 1, length - 1);
    robot.keyRelease(keyCodes[offset]);
  }

  public void clearTextField()
  {
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_A);
    robot.keyRelease(KeyEvent.VK_A);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_BACK_SPACE);
    robot.keyRelease(KeyEvent.VK_BACK_SPACE);
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_A);
    robot.keyRelease(KeyEvent.VK_A);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_BACK_SPACE);
    robot.keyRelease(KeyEvent.VK_BACK_SPACE);
  }

}
