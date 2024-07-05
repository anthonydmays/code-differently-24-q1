package com.codedifferently.lesson4;

public class ExpressionCalculator {

  /** Returns the calculation of ((a + b) * c) / d^e */
  public double calculate(double a, double b, double c, double d, double e) {
    double addition = add(a, b);
    double multiplication = multiply(addition, c);
    double power = pow(d, e);
    double division = divide(multiplication, power);
    return division;
  }

  public double add(double a, double b) {
    return a + b;
  }

  public double multiply(double a, double b) {
    return a * b;
  }

  public double divide(double a, double b) {
    return a / b;
  }

  public double pow(double base, double exponent) {
    return Math.pow(base, exponent);
  }
}
