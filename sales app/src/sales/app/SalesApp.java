package sales.app;

import java.text.DecimalFormat;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author KERO
 */
public class SalesApp extends Application {
    Stage window; 
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, comma, plus, equal, minus, divide, multiple, clear, back;
    TextField textField;
    Label oldValueLabel, operandLabel;
    Scene main,s1,s2,s3,s4 ,scene;
    
    
    
    double num;

    double answer;

    double oldAnswer;

    int operation;

    boolean isTextChanged = false;

    boolean noClickedOperator = true;

    boolean isEqualClicked = false;

    DecimalFormat format = new DecimalFormat("0.###############");

    Font font = Font.font("Calibri", FontWeight.NORMAL, 20);
        Font font1 = Font.font("Calibri", FontWeight.NORMAL, 15);

    private void calculateOldAnswer() {
        switch (operation) {
            case 1:
                oldAnswer += num;
                break;
            case 2:
                if (!oldValueLabel.getText().isEmpty()) {
                    oldAnswer -= num;
                } else {
                    oldAnswer = num - oldAnswer;
                }
                break;
            case 3:
                oldAnswer *= num;
                break;
            case 4:
                oldAnswer /= num;
                break;
        }
    }
    
       public Pane cal(){
        
        b0 = new Button("0");
        b1 = new Button("1");
        b2 = new Button("2");
        b3 = new Button("3");
        b4 = new Button("4");
        b5 = new Button("5");
        b6 = new Button("6");
        b7 = new Button("7");
        b8 = new Button("8");
        b9 = new Button("9");
        comma = new Button(".");
        plus = new Button("+");
        minus = new Button("-");
        multiple = new Button("×");
        divide = new Button("÷");
        equal = new Button("=");
        clear = new Button("C");
        back = new Button("←");
        textField = new TextField("0");
        oldValueLabel = new Label("");
        operandLabel = new Label("");

        oldValueLabel.setAlignment(Pos.CENTER_RIGHT);
        operandLabel.setAlignment(Pos.CENTER_RIGHT);
        textField.setAlignment(Pos.CENTER_RIGHT);
        
        textField.setEditable(false);
        
        oldValueLabel.setPrefSize(214, 20);
        oldValueLabel.setTranslateX(11);
        oldValueLabel.setTranslateY(5);
        operandLabel.setPrefSize(15, 20);
        operandLabel.setTranslateX(225);
        operandLabel.setTranslateY(5);
        textField.setPrefSize(234, 47);
        textField.setTranslateX(11);
        textField.setTranslateY(25);
        b7.setPrefSize(45, 42);
        b7.setTranslateX(10);
        b7.setTranslateY(80);
        b8.setPrefSize(45, 42);
        b8.setTranslateX(58);
        b8.setTranslateY(80);
        b9.setPrefSize(45, 42);
        b9.setTranslateX(106);
        b9.setTranslateY(80);
        plus.setPrefSize(45, 42);
        plus.setTranslateX(154);
        plus.setTranslateY(80);
        clear.setPrefSize(45, 42);
        clear.setTranslateX(202);
        clear.setTranslateY(80);
        b4.setPrefSize(45, 42);
        b4.setTranslateX(10);
        b4.setTranslateY(126);
        b5.setPrefSize(45, 42);
        b5.setTranslateX(58);
        b5.setTranslateY(126);
        b6.setPrefSize(45, 42);
        b6.setTranslateX(106);
        b6.setTranslateY(126);
        minus.setPrefSize(45, 42);
        minus.setTranslateX(154);
        minus.setTranslateY(126);
        back.setPrefSize(45, 42);
        back.setTranslateX(202);
        back.setTranslateY(126);
        b1.setPrefSize(45, 42);
        b1.setTranslateX(10);
        b1.setTranslateY(172);
        b2.setPrefSize(45, 42);
        b2.setTranslateX(58);
        b2.setTranslateY(172);
        b3.setPrefSize(45, 42);
        b3.setTranslateX(106);
        b3.setTranslateY(172);
        multiple.setPrefSize(45, 42);
        multiple.setTranslateX(154);
        multiple.setTranslateY(172);
        equal.setPrefSize(45, 88);
        equal.setTranslateX(202);
        equal.setTranslateY(172);
        b0.setPrefSize(93, 42);
        b0.setTranslateX(10);
        b0.setTranslateY(218);
        comma.setPrefSize(45, 42);
        comma.setTranslateX(106);
        comma.setTranslateY(218);
        divide.setPrefSize(45, 42);
        divide.setTranslateX(154);
        divide.setTranslateY(218);

        b0.setFont(font);
        b1.setFont(font);
        b2.setFont(font);
        b3.setFont(font);
        b4.setFont(font);
        b5.setFont(font);
        b6.setFont(font);
        b7.setFont(font);
        b8.setFont(font);
        b9.setFont(font);
        comma.setFont(font);
        equal.setFont(font);
        plus.setFont(font);
        minus.setFont(font);
        multiple.setFont(font);
        divide.setFont(font);
        clear.setFont(font);
        textField.setFont(Font.font("Monospaced", FontWeight.BOLD, 19));
        oldValueLabel.setFont(Font.font("Monospaced", FontWeight.BOLD, 17));
        operandLabel.setFont(Font.font("Monospaced", FontWeight.BOLD, 17));
        back.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

        oldValueLabel.setStyle("-fx-text-fill: DARKCYAN;");
        operandLabel.setStyle("-fx-text-fill: Black;");
        
        b0.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        b1.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        b2.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        b3.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        b4.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        b5.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        b6.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        b7.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        b8.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        b9.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        comma.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        plus.setStyle("-fx-text-fill: white; -fx-background-color: #222;");
        minus.setStyle("-fx-text-fill: white; -fx-background-color: #222;");
        multiple.setStyle("-fx-text-fill: white; -fx-background-color: #222;");
        divide.setStyle("-fx-text-fill: white; -fx-background-color: #222;");
        equal.setStyle("-fx-text-fill: white; -fx-background-color: #222;");
        clear.setStyle("-fx-text-fill: white; -fx-background-color: #E50101;");
        back.setStyle("-fx-text-fill: white; -fx-background-color: orangered;");

        EventHandler eventHandler = (new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (e.getSource() == b0)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("0");
                    else
                        textField.setText(textField.getText() + "0");
                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }
                else if (e.getSource() == b1)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("1");
                    else
                        textField.setText(textField.getText() + "1");
                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }
                else if (e.getSource() == b2)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("2");
                    else
                        textField.setText(textField.getText() + "2");
                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }

                else if (e.getSource() == b3)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("3");
                    else
                        textField.setText(textField.getText() + "3");
                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }

                else if (e.getSource() == b4)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("4");
                    else
                        textField.setText(textField.getText() + "4");
                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }

                else if (e.getSource() == b5)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("5");
                    else
                        textField.setText(textField.getText() + "5");
                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }
                else if (e.getSource() == b6)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("6");
                    else
                        textField.setText(textField.getText() + "6");
                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }
                else if (e.getSource() == b7)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("7");
                    else
                        textField.setText(textField.getText() + "7");
                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }
                else if (e.getSource() == b8)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("8");
                    else
                        textField.setText(textField.getText() + "8");
                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }
                else if (e.getSource() == b9)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("9");
                    else
                        textField.setText(textField.getText() + "9");
                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }
                else if (e.getSource() == comma)
                {
                    if (isEqualClicked == true || textField.getText().isEmpty())
                        textField.setText("0.");
                    else if (!textField.getText().contains("."))
                        textField.setText(textField.getText() + ".");
                    isEqualClicked = false;
                    isTextChanged = true;
                }
                else if (e.getSource() == plus && noClickedOperator == true)
                {
                    if (textField.getText().equals("0") && operandLabel.getText().equals("÷"))
                    {
                        textField.setText("cannot divide by 0");
                    }
                
                    else if (isTextChanged == true || oldValueLabel.getText().isEmpty())
                    {
                        try {
                            if (textField.getText().isEmpty()) {
                                num = 0;
                            }

                            else {
                                num = Double.parseDouble(textField.getText());
                            }

                            if (oldValueLabel.getText().isEmpty()) {
                                operation = 1;
                                oldAnswer = 0;
                            }

                            else {
                                oldAnswer = Double.parseDouble(oldValueLabel.getText());
                            }
                            calculateOldAnswer();
                            operandLabel.setText("+");
                            oldValueLabel.setText(format.format(oldAnswer));
                            textField.setText("");
                            operation = 1;
                        }
                        catch (Exception ex) {
                            textField.setText("Error");
                        }
                    }

                    isTextChanged = false;
                    noClickedOperator = false;
                }

                else if (e.getSource() == minus && noClickedOperator == true)
                {

                    if (textField.getText().equals("0") && operandLabel.getText().equals("÷"))
                    {
                        textField.setText("cannot divide by 0");
                    }

                    else if (isTextChanged == true || oldValueLabel.getText().isEmpty())
                    {
                        try {

                            if (textField.getText().isEmpty()) {
                                num = 0;
                            }

                            else {
                                num = Double.parseDouble(textField.getText());
                            }

                            if (oldValueLabel.getText().isEmpty()) {
                                operation = 2;
                                oldAnswer = 0;
                            }

                            else {
                                oldAnswer = Double.parseDouble(oldValueLabel.getText());
                            }

                            calculateOldAnswer();
                            operandLabel.setText("-");
                            oldValueLabel.setText(format.format(oldAnswer));
                            textField.setText("");

                            operation = 2;
                        }
                        catch (Exception ex) {
                            textField.setText("Error");
                        }
                    }

                    isTextChanged = false;
                    noClickedOperator = false;
                }

                else if (e.getSource() == multiple && noClickedOperator == true)
                {

                    if (textField.getText().equals("0") && operandLabel.getText().equals("÷"))
                    {
                        textField.setText("cannot divide by 0");
                    }

                    else if (isTextChanged == true || oldValueLabel.getText().isEmpty())
                    {
                        try {

                            if (textField.getText().isEmpty()) {
                                num = 1;
                            }

                            else {
                                num = Double.parseDouble(textField.getText());
                            }

                            if (oldValueLabel.getText().isEmpty()) {
                                operation = 3;
                                oldAnswer = 1;
                            }

                            else {
                                oldAnswer = Double.parseDouble(oldValueLabel.getText());
                            }

                            calculateOldAnswer();
                            operandLabel.setText("×");
                            oldValueLabel.setText(format.format(oldAnswer));
                            textField.setText("");

                            operation = 3;
                        }
                        catch (Exception ex) {
                            textField.setText("Error");
                        }
                    }

                    isTextChanged = false;
                    noClickedOperator = false;
                }

                else if (e.getSource() == divide && noClickedOperator == true)
                {

                    if (textField.getText().equals("0") && operandLabel.getText().equals("÷"))
                    {
                        textField.setText("cannot divide by 0");
                    }

                    else if (isTextChanged == true || oldValueLabel.getText().isEmpty())
                    {
                        try {

                            if (textField.getText().isEmpty()) {
                                num = 1;
                            }

                            else {
                                num = Double.parseDouble(textField.getText());
                            }
                            if (oldValueLabel.getText().isEmpty()) {
                                oldAnswer = num;
                            }
                            else {
                                oldAnswer = Double.parseDouble(oldValueLabel.getText());
                                calculateOldAnswer();
                            }

                            operandLabel.setText("÷");
                            oldValueLabel.setText(format.format(oldAnswer));
                            textField.setText("");

                            operation = 4;
                        } catch (Exception ex) {
                            textField.setText("Error");
                        }
                    }

                    isTextChanged = false;
                    noClickedOperator = false;
                }

                else if (e.getSource() == equal)
                {

                    if (!textField.getText().isEmpty() && !oldValueLabel.getText().isEmpty() && isEqualClicked == false)
                    {
                        double a = Double.parseDouble(oldValueLabel.getText());
                        double b = Double.parseDouble(textField.getText());
                        char operand = operandLabel.getText().charAt(0);
                        switch (operand) {
                            case '+':
                                answer = a + b;
                                textField.setText(format.format(answer));
                                break;
                            case '-':
                                answer = a - b;
                                textField.setText(format.format(answer));
                                break;
                            case '×':
                                answer = a * b;
                                textField.setText(format.format(answer));
                                break;
                            case '÷':
                                if (b == 0) {
                                    textField.setText("cannot divide by 0");
                                } else {
                                    answer = a / b;
                                    textField.setText(format.format(answer));
                                }
                                break;
                        }
                    }

                    else if (textField.getText().isEmpty() && !oldValueLabel.getText().isEmpty()) {
                        textField.setText(oldValueLabel.getText());
                    }

                    oldValueLabel.setText("");
                    operandLabel.setText("");

                    isEqualClicked = true;
                    noClickedOperator = true;
                }

                else if (e.getSource() == back)
                {
                   if (textField.getText().equals("Error") || textField.getText().equals("cannot divide by 0"))
                    {
                        textField.setText("");
                    }
                    else if (!textField.getText().isEmpty())
                    {
                        textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
                    }
                }

                else if (e.getSource() == clear)
                {
                    oldValueLabel.setText("");
                    textField.setText("");
                    operandLabel.setText("");
                    oldAnswer = 0;
                    num = 0;
                    noClickedOperator = true;
                }
            }
        });

        b0.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        b1.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        b2.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        b3.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        b4.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        b5.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        b6.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        b7.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        b8.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        b9.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        comma.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        plus.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        multiple.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        divide.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        minus.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        equal.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        clear.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        back.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        
        

        Pane root = new Pane();
        
        root.getChildren().add(b0);
        root.getChildren().add(b1);
        root.getChildren().add(b2);
        root.getChildren().add(b3);
        root.getChildren().add(b4);
        root.getChildren().add(b5);
        root.getChildren().add(b6);
        root.getChildren().add(b7);
        root.getChildren().add(b8);
        root.getChildren().add(b9);
        root.getChildren().add(comma);
        root.getChildren().add(equal);
        root.getChildren().add(plus);
        root.getChildren().add(multiple);
        root.getChildren().add(minus);
        root.getChildren().add(divide);
        root.getChildren().add(clear);
        root.getChildren().add(back);
        root.getChildren().add(textField);
        root.getChildren().add(oldValueLabel);
        root.getChildren().add(operandLabel);
      
           return root;
}
    
       
    /////////////////////////////////////
    @Override
    
    public void start(Stage primaryStage) {
       window=  primaryStage;
       
       //start welcome   
       Pane man=new Pane();
       
       Label wel=new Label(" welcome  ");
       wel.setFont(Font.font("Calibri", FontWeight.NORMAL, 30));
       wel.setLayoutX(200);
       wel.setLayoutY(30);
       wel.setStyle("-fx-text-fill: Black;");
    //// ////  Color.AQUA
       Text tpas=new Text("  Enter password");
       tpas.setLayoutX(30);
       tpas.setLayoutY(115);
       tpas.setFont(font1);
        PasswordField pass=new PasswordField();
        pass.setLayoutX(150);
        pass.setLayoutY(100);
            String k="keroo";    
        
         Text er=new Text("");
        er.setFont(font);
        er.setLayoutX(50);
        er.setLayoutY(250);
        
        Button bpas=new Button("  enter  ");
        bpas.setFont(font);
        bpas.setLayoutX(70);
        bpas.setLayoutY(170);
        bpas.setOnAction(e-> {window.setScene(scene);});
        man.setStyle("-fx-background-color: DARKCYAN;");
        man.getChildren().addAll(wel,tpas,pass,bpas,er);
         main=new Scene(man,550,350);
     //end welcome
        //stert app
        ImageView im=new ImageView(new Image(SalesApp.class.getResource("ss.png").toExternalForm(),250,200,true,true));
        ImageView im1=new ImageView(new Image(SalesApp.class.getResource("s.png").toExternalForm(),800,222,true,true));
         
        Label l =new Label(" welcome to sales app");
        l.setFont(new Font("Arial", 30));
        l.setTranslateX(370);
        l.setTranslateY(20);
        l.setTextFill(Color.PURPLE);
    //    l.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        l.setPadding(new Insets(10));
      
        VBox box=new VBox(40);
        box.setPadding(new Insets(60,0,10,120));
                
        Button stor =new Button(" المخزن   "+"    ");
        Button buy=new Button("   المشتريات "+"   ");
        Button sale=new Button("  المبيعات "+"   ");

        stor.setFont(font);
        buy.setFont(font);
        sale.setFont(font);
        
        stor.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        buy.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        sale.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
         
        box.getChildren().addAll(stor,buy,sale);
        
        stor.setOnAction(e ->{ window.setScene(s1); });
        buy.setOnAction(e ->{window.setScene(s3);});
        sale.setOnAction(e ->{window.setScene(s2); });
        
        //start store
        Pane pp=new Pane();
        pp.setStyle("-fx-background-color: DARKTURQUOISE;");
        
        Label t=new Label("  المخزن "+"   ");
        t.setLayoutX(200);
        t.setLayoutY(50);
        t.setFont(new Font("Arial", 35));
        t.setTextFill(Color.PURPLE);
        t.setUnderline(true);
        
        Button add=new Button("  اضافه سلعه "+"  ");
         add.setLayoutX(85);
        add.setLayoutY(150);
        Button show=new Button("  عرض سلعه "+"  ");
         show.setLayoutX(250);
        show.setLayoutY(150);
        Button back1=new Button(" back ");
                 back1.setOnAction(e ->{ primaryStage.setScene(scene);});
         back1.setLayoutX(30);
         back1.setLayoutY(350);
        
        back1.setFont(font1);
        add.setFont(font);
        show.setFont(font);
      //  .Color.DARKTURQUOISE
        add.setOnAction(e-> window.setScene(s4));
        
        back1.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        add.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        show.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        
        pp.getChildren().addAll(t,add,show,back1);
        s1=new Scene(pp,600,400);
        //start sales
        
        Pane pp1=new Pane();
        pp1.setStyle("-fx-background-color: DARKTURQUOISE;");
        
        Label t1=new Label("  المبيعات "+"   ");
        t1.setLayoutX(200);
        t1.setLayoutY(50);
        t1.setFont(new Font("Arial", 35));
        t1.setTextFill(Color.PURPLE);
        t1.setUnderline(true);
        
        Button sa=new Button("  بيع "+"  ");
         sa.setLayoutX(85);
        sa.setLayoutY(150);
        Button show1=new Button("  عرض المبيعات "+"  ");
         show1.setLayoutX(250);
        show1.setLayoutY(150);
        Button back2=new Button(" back ");
                 back2.setOnAction(e ->{ primaryStage.setScene(scene);});
         back2.setLayoutX(30);
         back2.setLayoutY(350);
        
        back2.setFont(font1);
        sa.setFont(font);
        show1.setFont(font);
      //  .Color.DARKTURQUOISE
        back2.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        sa.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        show1.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        
        pp1.getChildren().addAll(t1,sa,show1,back2);
        s2=new Scene(pp1,600,400);
        
        //end sales
        // start  buying 
        VBox hb=new VBox(45);
        VBox hb1=new VBox(40);
        HBox vb=new HBox(35);
        vb.setPadding(new Insets(15,0,30,30));
      
        Label bu =new Label(" المشتريات ");
        bu.setFont(new Font("Arial", 40));
        bu.setTextFill(Color.PURPLE);
        bu.setUnderline(true);
        
        Text tbuy1=new Text(" السعر"+"  ");
        tbuy1.setFont(font);
        tbuy1.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        TextField tf1=new TextField();
        
        Text tbuy2=new Text(" الكمية"+"  ");
        tbuy2.setFont(font);
        tbuy2.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        TextField tf2=new TextField();
        
        Text tbuy3=new Text(" النوع"+"  ");
        tbuy3.setFont(font);
        tbuy3.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        TextField tf3=new TextField();
        
        Text tbuy4=new Text("اسم الشركه "+" ");
        tbuy4.setFont(font);
        tbuy4.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        TextField tf4=new TextField();
        
        Text tbuy5=new Text(" التاريخ"+"  ");
        tbuy5.setFont(font);
        tbuy5.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        DatePicker dp=new DatePicker(LocalDate.now());
        
        Button back3=new Button(" back ");
                 back3.setOnAction(e ->{ primaryStage.setScene(scene);});
                 back3.setFont(font1);
                 back3.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");         
              
        Button enter1=new Button(" ادخال "+"  ");
          enter1.setOnAction(e ->{
          }); 
                enter1.setFont(font);
                enter1.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");         
                
        
        hb.getChildren().addAll(tbuy1,tbuy2,tbuy3,tbuy4,tbuy5,back3);
        hb1.getChildren().addAll(tf1,tf2,tf3,tf4,dp,enter1);
        vb.getChildren().addAll(bu,hb,hb1);
        vb.setStyle("-fx-background-color: DARKTURQUOISE;");
        
        s3=new Scene(vb,700,450);
        //end buying 
 
        // start add
        Pane  padd=new Pane();
        
        Label lb =new Label("اضافه   ");
        lb.setFont(new Font("Arial", 40));
        lb.setTextFill(Color.PURPLE);
        lb.setUnderline(true);
        lb.setLayoutX(250); lb.setLayoutY(30);
        
        Text tadd1=new Text(" نوع السياره"+"  ");
        tadd1.setFont(font);
        tadd1.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        tadd1.setLayoutX(80); tadd1.setLayoutY(155);
        
        TextField tfd1=new TextField();
        tfd1.setLayoutX(200); tfd1.setLayoutY(140);
        
        Text tadd2=new Text(" الموديل "+"  ");
        tadd2.setFont(font);
        tadd2.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        tadd2.setLayoutX(80); tadd2.setLayoutY(185);
        
        TextField tfd2=new TextField();
        tfd2.setLayoutX(200); tfd2.setLayoutY(175);
        
        Text tadd3=new Text(" اسم المنتج "+"  ");
        tadd3.setFont(font);
        tadd3.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        tadd3.setLayoutX(80); tadd3.setLayoutY(215);
        
        TextField tfd3=new TextField();
        tfd3.setLayoutX(200); tfd3.setLayoutY(205);
        
        Text tadd4=new Text(" الكميه "+" ");
        tadd4.setFont(font);
        tadd4.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        tadd4.setLayoutX(80); tadd4.setLayoutY(245);
        
        TextField tfd4=new TextField();
        tfd4.setLayoutX(200); tfd4.setLayoutY(235);
        
        Text tadd5=new Text(" السعر  "+"  ");
        tadd5.setFont(font);
        tadd5.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");
        tadd5.setLayoutX(80); tadd5.setLayoutY(275);
        
        TextField tfd5=new TextField();
        tfd5.setLayoutX(200); tfd5.setLayoutY(265);
        
        Button badd4=new Button(" back ");
                 badd4.setOnAction(e ->{ primaryStage.setScene(s1);});
                 badd4.setFont(font1);
                 badd4.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");         
                 badd4.setLayoutX(50); badd4.setLayoutY(500);
                 padd.getChildren().add(badd4);

        Button  enter2=new Button(" اضافه "+"  ");
                enter2.setOnAction(e ->{ 
          }); 
                enter2.setFont(font);
                enter2.setStyle("-fx-text-fill: white; -fx-background-color: dimgray;");       
                enter2.setLayoutX(130); enter2.setLayoutY(400);
                      
                padd.getChildren().add(enter2);
                padd.setStyle("-fx-background-color: DARKTURQUOISE;");
        padd.getChildren().addAll(lb,tadd1,tfd1,tadd2,tfd2,tadd3,tfd3,tadd4,tfd4,tadd5,tfd5);
      
        s4=new Scene(padd, 650, 400);
        
        // end add
        BorderPane p = new BorderPane();
            p.setLeft(cal());
            p.setTop(l);
            p.setCenter(box);
            p.setRight(im);
            p.setBottom(im1);
            
             scene = new Scene(p, 800, 600);
        
            
        primaryStage.setTitle("sales app ");
        primaryStage.setResizable(false);
        primaryStage.setScene(main);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
 
    }
}