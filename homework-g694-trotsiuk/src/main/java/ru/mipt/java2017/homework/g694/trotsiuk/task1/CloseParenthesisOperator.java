package ru.mipt.java2017.homework.g694.trotsiuk.task1;

import ru.mipt.java2017.homework.base.task1.ParsingException;

import java.util.EmptyStackException;
import java.util.Stack;


public final class CloseParenthesisOperator extends Operator {

  @Override
  protected int priority() throws ParsingException {
    throw new ParsingException("Logical error: close parenthesis is never checked for priority");
  }

  @Override
  protected void makeOperation(Stack<NumberOperator> results) throws ParsingException {
    throw new ParsingException("Logical error: close parenthesis can't make any operation");
  }

  @Override
  public void addLexeme(Stack<NumberOperator> results, Stack<Operator> operations) throws ParsingException {
    try {
      while (operations.peek().priority() != 0) {
        Operator operation = operations.pop();
        operation.makeOperation(results);
      }
    } catch (EmptyStackException e) {
      throw new ParsingException("No parenthesis balance");
    }
    operations.pop();
  }
}
