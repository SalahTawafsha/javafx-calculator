package com.example.calculatorusingcursorarraystack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private static final CursorStack<String> stack = new CursorStack<>(50);

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");
        primaryStage.getIcons().add(new Image(getResource("icon.png")));
        primaryStage.setResizable(false);

        TextField expression = new TextField();
        expression.setEditable(false);
        expression.setMinHeight(50);
        expression.setMaxWidth(300);

        TextField postfix = new TextField();
        postfix.setEditable(false);
        postfix.setMinHeight(50);
        postfix.setMaxWidth(300);

        TextField result = new TextField();
        result.setEditable(false);
        result.setMinHeight(30);
        result.setMaxWidth(300);

        VBox up = new VBox(0, expression, postfix, result);
        up.setAlignment(Pos.CENTER);

        GridPane pane = new GridPane();
        pane.setVgap(3);
        pane.setHgap(3);

        Button sin = new Button("sin");
        sin.setId("blue-button");
        sin.setOnAction(e -> expression.setText(expression.getText() + "sin ( "));

        Button cos = new Button("cos");
        cos.setId("blue-button");
        cos.setOnAction(e -> expression.setText(expression.getText() + "cos ( "));

        Button tan = new Button("tan");
        tan.setId("blue-button");
        tan.setOnAction(e -> expression.setText(expression.getText() + "tan ( "));

        Button openDelimiter = new Button("(");
        openDelimiter.setId("white-button");
        openDelimiter.setOnAction(e -> expression.setText(expression.getText() + "( "));

        Button closeDelimiter = new Button(")");
        closeDelimiter.setId("white-button");
        closeDelimiter.setOnAction(e -> expression.setText(expression.getText() + " )"));

        Button fact = new Button("!");
        fact.setId("blue-button");
        fact.setOnAction(e -> expression.setText(expression.getText() + " ! "));

        Button minusSign = getButton(expression);


        pane.addRow(0, sin, cos, tan, fact, openDelimiter, closeDelimiter, minusSign);

        ImageView piIcon = new ImageView(getResource("pi.png"));
        piIcon.setFitWidth(20);
        piIcon.setFitHeight(20);
        Button piButton = new Button("", piIcon);
        piButton.setId("blue-button");
        piButton.setOnAction(e -> expression.setText(expression.getText() + "3.141592653589793"));

        ImageView powIcon = new ImageView(getResource("pow.png"));
        powIcon.setFitWidth(20);
        powIcon.setFitHeight(20);
        Button powButton = new Button("", powIcon);
        powButton.setId("blue-button");
        powButton.setOnAction(e -> expression.setText(expression.getText() + " ^ "));

        Button seven = new Button("7");
        seven.setId("black-button");
        seven.setOnAction(e -> expression.setText(expression.getText() + "7"));

        Button eight = new Button("8");
        eight.setId("black-button");
        eight.setOnAction(e -> expression.setText(expression.getText() + "8"));

        Button nine = new Button("9");
        nine.setId("black-button");
        nine.setOnAction(e -> expression.setText(expression.getText() + "9"));

        ImageView divide = new ImageView(getResource("divide.png"));
        divide.setFitWidth(20);
        divide.setFitHeight(20);
        Button divideButton = new Button("", divide);
        divideButton.setId("gray-button");
        divideButton.setOnAction(e -> expression.setText(expression.getText() + " / "));

        Button off = new Button("off");
        off.setId("red-button");

        off.setOnAction(e -> primaryStage.close());

        pane.addRow(1, piButton, powButton, seven, eight, nine, divideButton, off);

        ImageView xToPow2Icon = new ImageView(getResource("xSqr.png"));
        xToPow2Icon.setFitWidth(20);
        xToPow2Icon.setFitHeight(20);
        Button xPowButton = new Button("", xToPow2Icon);
        xPowButton.setId("blue-button");
        xPowButton.setOnAction(e -> expression.setText(expression.getText() + " ^ 2"));

        ImageView sqrtView = new ImageView(getResource("sqrt.png"));
        sqrtView.setFitWidth(20);
        sqrtView.setFitHeight(20);
        Button sqrtButton = new Button("", sqrtView);
        sqrtButton.setId("blue-button");
        sqrtButton.setOnAction(e -> expression.setText(expression.getText() + "sqrt ( "));

        Button four = new Button("4");
        four.setId("black-button");
        four.setOnAction(e -> expression.setText(expression.getText() + "4"));

        Button five = new Button("5");
        five.setId("black-button");
        five.setOnAction(e -> expression.setText(expression.getText() + "5"));

        Button six = new Button("6");
        six.setId("black-button");
        six.setOnAction(e -> expression.setText(expression.getText() + "6"));

        Button multiply = new Button("X");
        multiply.setId("gray-button");
        multiply.setOnAction(e -> expression.setText(expression.getText() + " * "));

        Button ca = new Button("CA");
        ca.setId("red-button");
        ca.setOnAction(e -> {
            stack.clear();
            expression.setText("");
            postfix.setText("");
            result.setText("");
        });

        pane.addRow(2, xPowButton, sqrtButton, four, five, six, multiply, ca);

        ImageView expIcon = new ImageView(getResource("exp.png"));
        expIcon.setFitWidth(20);
        expIcon.setFitHeight(20);
        Button expButton = new Button("", expIcon);
        expButton.setId("blue-button");
        expButton.setOnAction(e -> expression.setText(expression.getText() + "exp ( "));

        Button lnButton = new Button("ln");
        lnButton.setId("blue-button");
        lnButton.setOnAction(e -> expression.setText(expression.getText() + "ln ( "));

        Button one = new Button("1");
        one.setId("black-button");
        one.setOnAction(e -> expression.setText(expression.getText() + "1"));

        Button two = new Button("2");
        two.setId("black-button");
        two.setOnAction(e -> expression.setText(expression.getText() + "2"));

        Button three = new Button("3");
        three.setId("black-button");
        three.setOnAction(e -> expression.setText(expression.getText() + "3"));

        Button minus = new Button("-");
        minus.setId("gray-button");
        minus.setOnAction(e -> expression.setText(expression.getText() + " - "));

        Button radDeg = new Button("Deg");
        radDeg.setId("red-button");
        radDeg.setOnAction(e -> {
            if (radDeg.getText().equals("Deg"))
                radDeg.setText("Rad");
            else
                radDeg.setText("Deg");
        });

        pane.addRow(3, expButton, lnButton, one, two, three, minus, radDeg);

        Button log = new Button("LOG");
        log.setId("blue-button");
        log.setOnAction(e -> expression.setText(expression.getText() + "log ( "));

        ImageView oneDivideByXView = new ImageView(getResource("1onx.png"));
        oneDivideByXView.setFitWidth(20);
        oneDivideByXView.setFitHeight(20);
        Button oneDivideByX = new Button("", oneDivideByXView);
        oneDivideByX.setId("blue-button");
        oneDivideByX.setOnAction(e -> expression.setText(expression.getText() + "1 / "));

        Button add = new Button("+");
        add.setId("gray-button");
        add.setOnAction(e -> expression.setText(expression.getText() + " + "));

        Button mod = new Button("%");
        mod.setId("gray-button");
        mod.setOnAction(e -> expression.setText(expression.getText() + " % "));

        Button point = new Button(".");
        point.setId("gray-button");
        point.setOnAction(e -> expression.setText(expression.getText() + "."));

        ImageView back = new ImageView(getResource("back.png"));
        back.setFitWidth(20);
        back.setFitHeight(20);
        Button backButton = getButton(back, expression);

        Button zero = new Button("0");
        zero.setId("black-button");
        zero.setOnAction(e -> expression.setText(expression.getText() + "0"));

        pane.addRow(4, log, oneDivideByX, zero, point, mod, add, backButton);
        pane.setPadding(new Insets(5, 5, 0, 5));

        Button equal = new Button("=");
        equal.setId("equal-button");

        equal.setOnAction(e -> {
            if (checkBraces(expression.getText())) {
                try {
                    stack.clear();
                    postfix.setText(toPostfix(expression.getText()));
                    result.setText(evaluate(postfix.getText(), radDeg.getText()) + "");
                } catch (ArithmeticException e1) {
                    postfix.setText("");
                    result.setText(e1.getMessage());
                } catch (Exception e2) {
                    stack.clear();
                    postfix.setText("");
                    result.setText("Invalid Expression");
                }
            } else {
                stack.clear();
                postfix.setText("");
                result.setText("Error in Braces");
            }

        });

        VBox all = new VBox(5, up, pane, equal);
        all.setPadding(new Insets(30, 20, 30, 20));

        all.setAlignment(Pos.CENTER);
        all.setBackground(new Background(new BackgroundImage(new Image(getResource("backg.png")), null, null, null, null)));

        Scene s = new Scene(all);
        s.getStylesheets().add(getResource("style.css"));
        primaryStage.setScene(s);
        primaryStage.show();
    }

    private Button getButton(ImageView back, TextField expression) {
        Button backButton = new Button("", back);
        backButton.setId("red-button");
        backButton.setOnAction(e -> {
            String exp = expression.getText();

            if (exp.length() > 1 && Character.isDigit(exp.charAt(exp.length() - 1))
                    || exp.charAt(exp.length() - 1) == '.')
                exp = exp.substring(0, exp.length() - 1);
            else if (exp.length() > 3 && exp.charAt(exp.length() - 2) == '(')
                exp = exp.substring(0, exp.length() - 2);
            else
                exp = exp.substring(0, lastSpace(exp));
            expression.setText(exp);
        });
        return backButton;
    }

    private static Button getButton(TextField expression) {
        Button minusSign = new Button("(-)");
        minusSign.setId("white-button");
        minusSign.setOnAction(e -> {
            if (!expression.getText().isEmpty()
                    && expression.getText().charAt(expression.getText().length() - 1) == '-')
                expression.setText(expression.getText().substring(0, expression.getText().length() - 1));
            else
                expression.setText(expression.getText() + "-");

        });
        return minusSign;
    }

    private String getResource(String resource) {
        return Main.class.getResource(resource).toExternalForm();
    }

    private int lastSpace(String exp) {
        for (int i = exp.length() - 2; i >= 0; i--)
            if (exp.charAt(i) == ' ')
                return i + 1;

        return 0;
    }

    private boolean checkBraces(String text) {
        String ch;

        if (text.isEmpty())
            return true;

        for (int i = 0; i < text.length(); i++)
            if (text.charAt(i) == '(')
                stack.push("(");
            else if (text.charAt(i) == ')') {
                ch = stack.pop();
                if (ch == null || !ch.equals("("))
                    return false;
            }

        if (!stack.isEmpty()) {
            stack.clear();
            return false;
        } else {
            return true;
        }

    }

    private String toPostfix(String s) {
        String[] tokens = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String token : tokens)
            switch (token) {
                case "+", "-" -> {
                    while (!stack.isEmpty() && !stack.peek().equals("("))
                        result.append(" ").append(stack.pop());
                    stack.push(token);
                }
                case "/", "*", "%" -> {
                    while (!stack.isEmpty() && !hasPrecedence(token, stack.peek()) && !stack.peek().equals("("))
                        result.append(" ").append(stack.pop());
                    stack.push(token);
                }
                case "^", "(", "tan", "cos", "sin", "sqrt", "exp", "ln", "log", "-tan", "-cos", "-sin", "-sqrt", "-exp", "-ln", "-log" ->
                        stack.push(token);
                case ")" -> {
                    while (!stack.isEmpty() && !stack.peek().equals("("))
                        result.append(" ").append(stack.pop());
                    stack.pop();
                }
                case "" -> {
                }
                default -> result.append(" ").append(token);
            }
        while (!stack.isEmpty())
            result.append(" ").append(stack.pop());

        return result.toString();
    }

    private boolean hasPrecedence(String op1, String op2) {
        if (op1.equals("+") || op1.equals("-"))
            return false;
        else return op2.equals("+") || op2.equals("-");
    }

    private double evaluate(String text, String radDeg) throws ArithmeticException {
        String[] tokens = text.split(" ");
        double res, x, y;
        for (int i = 0; i < tokens.length; i++) {
            boolean bobo = false;
            if (tokens[i].length() > 2 && tokens[i].charAt(0) == '-' && !Character.isDigit(tokens[i].charAt(1))) {
                tokens[i] = tokens[i].substring(1);
                bobo = true;
            }
            switch (tokens[i]) {
                case "+" -> {
                    res = Double.parseDouble(stack.pop()) + Double.parseDouble(stack.pop());
                    stack.push(String.format("%.9f", res));
                }
                case "-" -> {
                    res = -Double.parseDouble(stack.pop()) + Double.parseDouble(stack.pop());
                    stack.push(String.format("%.9f", res));
                }
                case "/" -> {
                    y = Double.parseDouble(stack.pop());
                    x = Double.parseDouble(stack.pop());
                    if (y != 0)
                        res = x / y;
                    else
                        throw new ArithmeticException("Cannot divide by zero");
                    stack.push(String.format("%.9f", res));
                }
                case "*" -> {
                    res = Double.parseDouble(stack.pop()) * Double.parseDouble(stack.pop());
                    stack.push(String.format("%.9f", res));
                }
                case "%" -> {
                    y = Double.parseDouble(stack.pop());
                    x = Double.parseDouble(stack.pop());
                    res = x % y;
                    stack.push(String.format("%.9f", res));
                }
                case "^" -> {
                    y = Double.parseDouble(stack.pop());
                    x = Double.parseDouble(stack.pop());
                    res = Math.pow(x, y);
                    stack.push(String.format("%.9f", res));
                }
                case "!" -> {
                    if (Integer.parseInt(stack.peek()) < 0)
                        throw new ArithmeticException("Invalid Expression");
                    res = factorial(Integer.parseInt(stack.pop()));
                    stack.push(String.format("%.9f", res));
                }
                case "tan" -> {
                    if (radDeg.equals("Deg"))
                        res = Math.tan(Math.toRadians(Double.parseDouble(stack.pop())));
                    else
                        res = Math.tan(Double.parseDouble(stack.pop()));
                    if (bobo)
                        res *= -1;
                    stack.push(String.format("%.9f", res));
                }
                case "cos" -> {
                    if (radDeg.equals("Deg"))
                        res = Math.cos(Math.toRadians(Double.parseDouble(stack.pop())));
                    else
                        res = Math.cos(Double.parseDouble(stack.pop()));
                    if (bobo)
                        res *= -1;
                    stack.push(String.format("%.9f", res));
                }
                case "sin" -> {
                    if (radDeg.equals("Deg"))
                        res = Math.sin(Math.toRadians(Double.parseDouble(stack.pop())));
                    else
                        res = Math.sin(Double.parseDouble(stack.pop()));
                    if (bobo)
                        res *= -1;
                    stack.push(String.format("%.9f", res));
                }
                case "sqrt" -> {
                    res = Math.sqrt((Double.parseDouble(stack.pop())));
                    if (bobo)
                        res *= -1;
                    stack.push(String.format("%.9f", res));
                }
                case "exp" -> {
                    res = Math.exp((Double.parseDouble(stack.pop())));
                    if (bobo)
                        res *= -1;
                    stack.push(String.format("%.9f", res));
                }
                case "ln" -> {
                    res = Math.log((Double.parseDouble(stack.pop())));
                    if (bobo)
                        res *= -1;
                    stack.push(String.format("%.9f", res));
                }
                case "log" -> {
                    res = Math.log10((Double.parseDouble(stack.pop())));
                    if (bobo)
                        res *= -1;
                    stack.push(String.format("%.9f", res));
                }
                case "" -> {
                }
                default -> stack.push(tokens[i]);
            }
        }
        return Double.parseDouble(stack.pop());

    }

    private long factorial(int n) {
        if (n <= 2) {
            return n;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        launch();
    }
}