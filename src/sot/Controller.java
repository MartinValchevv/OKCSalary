package sot;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


import java.io.IOException;



public class Controller {

    public javafx.scene.control.TabPane TabPane;

//  таб Старши

    public TextField n1; // Поле: Брой Дежурства
    public TextField n2; // Поле: Подсилки / извънредни
    public TextField n3; // Поле: Отпуск
    public TextField n4; // Поле: Празнични часове
    public TextField n5; // Поле: Прослужени години
    public TextField n6; // Поле: Награди
    public TextField n7; // Поле: Глоби
    public Button buttonSum;
    public TextField sum; // Поле: Обща заработка
    public Button bottomClear;
    public Button bottomGo; // Бутон стрелка в таб Старши

    // Таб Атестация

    public TextField t1; // Поле: Брой Дежурства
    public TextField t2; // Поле: Отпуск
    public TextField t3; // Поле: Празнични часове
    public TextField t4; // Поле: Прослужени години
    public TextField t5; // Поле: Награди
    public TextField t6;  // Поле: Глоби
    public TextField sumA; // Поле: Обща заработка
    public Button bottomSumA;
    public Button bottomClearA;
    public Button bottomGoA;

    // Таб Без атестация

    public TextField b1; // Поле: Брой Дежурства
    public TextField b2; // Поле: Отпуск
    public TextField b3; // Поле: Празнични часове
    public TextField b4; // Поле: Прослужени години
    public TextField b5; // Поле: Награди
    public TextField b6;  // Поле: Глоби
    public TextField sumB; // Поле: Обща заработка
    public Button bottomSumB;
    public Button bottomClearB;
    public Button bottomGoB;

    // Таб Колко пари трябва да взема в плик

    public Tab tabPlik; // Име на таб-а
    public TextField c1; // Поле: Обща заработка
    public TextField c2; // Поле: Превод по карта
    public TextField c3; // Поле: Удръжки
    public TextField c4; // Поле: Други удръжки
    public TextField SumC; // Поле: В плик трябва да взема
    public Button bottomClearC;
    public Button bottomSumC;

    public JFXButton bottomTry; // Бутон за "Опитай отново" от прозореца за грешка


    // Логиката за пресмятане в таб Старши


    public void calculate(ActionEvent actionEvent) throws Exception {

        try {

            double DejSt = Double.parseDouble(n1.getText().replace(',', '.'));
            double stHours = DejSt * 12;
            double dejstSum = stHours * 7.50;

            double podsilki = Double.parseDouble(n2.getText().replace(',', '.'));
            double podsilkiHours = podsilki * 12;
            double podsilkiSum = podsilkiHours * 6.50;

            double otpusk = Double.parseDouble(n3.getText().replace(',', '.'));
            double otpuskHours = otpusk * 8;
            double otpuskSum = otpuskHours * 7.00;

            double praznichni = Double.parseDouble(n4.getText().replace(',', '.'));
            double praznichniSum = praznichni * 2.50;

            double proslujeno = Double.parseDouble(n5.getText().replace(',', '.'));
            double proslujenoSum = proslujeno * 5;

            double nagradi = Double.parseDouble(n6.getText().replace(',', '.'));
            double globi = Double.parseDouble(n7.getText().replace(',', '.'));

            double result = (dejstSum + podsilkiSum + otpuskSum + praznichniSum + proslujenoSum + nagradi) - globi;

            this.sum.setText(String.format("%.2fлв.", result));
        } catch (Exception e) {
            this.sum.setText("Error");
            // Прозореца за грешка
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("error.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image(Main.class.getResourceAsStream("ico.png")));
            stage.setTitle("Грешка");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        }
    }


    // Логиката на бутона "Изчисти" за таб Старши

    public void clear(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bottomClear) {
            n1.setText("0");
            n2.setText("0");
            n3.setText("0");
            n4.setText("0");
            n5.setText("0");
            n6.setText("0");
            n7.setText("0");
            sum.setText("");
        }
    }

    // Логиката за пресмятане в таб Атестация

    public void calculateA(ActionEvent actionEvent) throws IOException {

        try {

            double DejT = Double.parseDouble(t1.getText().replace(',', '.'));
            double stHoursT = DejT * 12;
            double dejSumT = stHoursT * 6.50;

            double otpuskT = Double.parseDouble(t2.getText().replace(',', '.'));
            double otpuskHoursT = otpuskT * 8;
            double otpuskSumT = otpuskHoursT * 6.00;

            double praznichniT = Double.parseDouble(t3.getText().replace(',', '.'));
            double praznichniSumT = praznichniT * 2.50;

            double proslujenoT = Double.parseDouble(t4.getText().replace(',', '.'));
            double proslujenoSumT = proslujenoT * 5;

            double nagradiT = Double.parseDouble(t5.getText().replace(',', '.'));
            double globiT = Double.parseDouble(t6.getText().replace(',', '.'));

            double resultT = (dejSumT + otpuskSumT + praznichniSumT + proslujenoSumT + nagradiT) - globiT;

            this.sumA.setText(String.format("%.2fлв.", resultT));
        } catch (Exception e) {
            this.sumA.setText("Error");
            // Прозореца за грешка
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("error.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image(Main.class.getResourceAsStream("ico.png")));
            stage.setTitle("Грешка");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        }
    }

    // Логиката на бутона "Изчисти" за таб Атестация

    public void clearA(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bottomClearA) {
            t1.setText("0");
            t2.setText("0");
            t3.setText("0");
            t4.setText("0");
            t5.setText("0");
            t6.setText("0");
            sumA.setText("");
        }
    }

    // Логиката за пресмятане в таб Без Атестация

    public void calculateB(ActionEvent actionEvent) throws IOException {

        try {

            double DejB = Double.parseDouble(b1.getText().replace(',', '.'));
            double stHoursB = DejB * 12;
            double dejSumB = stHoursB * 6.00;

            double otpuskB = Double.parseDouble(b2.getText().replace(',', '.'));
            double otpuskHoursB = otpuskB * 8;
            double otpuskSumB = otpuskHoursB * 6.00;

            double praznichniB = Double.parseDouble(b3.getText().replace(',', '.'));
            double praznichniSumB = praznichniB * 2.50;

            double proslujenoB = Double.parseDouble(b4.getText().replace(',', '.'));
            double proslujenoSumB = proslujenoB * 5;

            double nagradiB = Double.parseDouble(b5.getText().replace(',', '.'));
            double globiB = Double.parseDouble(b6.getText().replace(',', '.'));

            double resultB = (dejSumB + otpuskSumB + praznichniSumB + proslujenoSumB + nagradiB) - globiB;

            this.sumB.setText(String.format("%.2fлв.", resultB));
        } catch (Exception e) {
            this.sumB.setText("Error");
            // Прозореца за грешка
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("error.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image(Main.class.getResourceAsStream("ico.png")));
            stage.setTitle("Грешка");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        }
    }

    // Логиката на бутона "Изчисти" за таб Без атестация

    public void clearB(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bottomClearB) {
            b1.setText("0");
            b2.setText("0");
            b3.setText("0");
            b4.setText("0");
            b5.setText("0");
            b6.setText("0");
            sumB.setText("");
        }
    }

    // Логиката за пресмятане на таб Колко пари трябва да взема в плик

    public void calculateC(ActionEvent actionEvent) throws IOException {

        try {

            double allSum = Double.parseDouble(c1.getText().replace(',', '.'));
            if (allSum < 60) {
                SumC.setText("Error");
                // Прозореца за грешка
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("error.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.getIcons().add(new Image(Main.class.getResourceAsStream("ico.png")));
                stage.setTitle("Грешка");
                stage.setScene(new Scene(root1));
                stage.setResizable(false);
                stage.show();
                return;
            }
            double card = Double.parseDouble(c2.getText().replace(',', '.'));
            double udrajki = Double.parseDouble(c3.getText().replace(',', '.'));
            double drugi = Double.parseDouble(c4.getText().replace(',', '.'));

            double resultC = allSum - 60 - card - udrajki - drugi;

            this.SumC.setText(String.format("%.2fлв. и 60 лв. ваучери", resultC));
        } catch (Exception e) {
            this.SumC.setText("Error");
            // Прозореца за грешка
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("error.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image(Main.class.getResourceAsStream("ico.png")));
            stage.setTitle("Грешка");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        }
    }

    // Логиката на бутона "Изчисти" за таб Колко пари трябва да взема в плик

    public void ClearC(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bottomClearC) {
            c1.setText("0");
            c2.setText("0");
            c3.setText("0");
            c4.setText("0");
            SumC.setText("");
        }
    }

    // Логиката за бутона "Стрелка" за таб Старши

    public void go(ActionEvent actionEvent) throws IOException {

        TabPane.getSelectionModel().select(tabPlik);

        try {

            double DejSt = Double.parseDouble(n1.getText().replace(',', '.'));
            double stHours = DejSt * 12;
            double dejstSum = stHours * 7.50;

            double podsilki = Double.parseDouble(n2.getText().replace(',', '.'));
            double podsilkiHours = podsilki * 12;
            double podsilkiSum = podsilkiHours * 6.50;

            double otpusk = Double.parseDouble(n3.getText().replace(',', '.'));
            double otpuskHours = otpusk * 8;
            double otpuskSum = otpuskHours * 7.00;

            double praznichni = Double.parseDouble(n4.getText().replace(',', '.'));
            double praznichniSum = praznichni * 2.50;

            double proslujeno = Double.parseDouble(n5.getText().replace(',', '.'));
            double proslujenoSum = proslujeno * 5;

            double nagradi = Double.parseDouble(n6.getText().replace(',', '.'));
            double globi = Double.parseDouble(n7.getText().replace(',', '.'));

            double result = (dejstSum + podsilkiSum + otpuskSum + praznichniSum + proslujenoSum + nagradi) - globi;

            this.c1.setText(result + "");
        } catch (Exception e) {
            this.c1.setText("Error");
            // Прозореца за грешка
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("error.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image(Main.class.getResourceAsStream("ico.png")));
            stage.setTitle("Грешка");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        }
    }

    // Логиката за бутона "Стрелка" за таб Атестация

    public void goA(ActionEvent actionEvent) throws IOException {

        TabPane.getSelectionModel().select(tabPlik);

        try {

            double DejT = Double.parseDouble(t1.getText().replace(',', '.'));
            double stHoursT = DejT * 12;
            double dejSumT = stHoursT * 6.50;

            double otpuskT = Double.parseDouble(t2.getText().replace(',', '.'));
            double otpuskHoursT = otpuskT * 8;
            double otpuskSumT = otpuskHoursT * 6.00;

            double praznichniT = Double.parseDouble(t3.getText().replace(',', '.'));
            double praznichniSumT = praznichniT * 2.50;

            double proslujenoT = Double.parseDouble(t4.getText().replace(',', '.'));
            double proslujenoSumT = proslujenoT * 5;

            double nagradiT = Double.parseDouble(t5.getText().replace(',', '.'));
            double globiT = Double.parseDouble(t6.getText().replace(',', '.'));

            double resultT = (dejSumT + otpuskSumT + praznichniSumT + proslujenoSumT + nagradiT) - globiT;

            this.c1.setText(resultT + "");
        } catch (Exception e) {
            this.c1.setText("Error");
            // Прозореца за грешка
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("error.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image(Main.class.getResourceAsStream("ico.png")));
            stage.setTitle("Грешка");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        }
    }

    // Логиката за бутона "Стрелка" за таб Без Атестация

    public void goB(ActionEvent actionEvent) throws IOException {

        TabPane.getSelectionModel().select(tabPlik);

        try {

            double DejB = Double.parseDouble(b1.getText().replace(',', '.'));
            double stHoursB = DejB * 12;
            double dejSumB = stHoursB * 6.00;

            double otpuskB = Double.parseDouble(b2.getText().replace(',', '.'));
            double otpuskHoursB = otpuskB * 8;
            double otpuskSumB = otpuskHoursB * 6.00;

            double praznichniB = Double.parseDouble(b3.getText().replace(',', '.'));
            double praznichniSumB = praznichniB * 2.50;

            double proslujenoB = Double.parseDouble(b4.getText().replace(',', '.'));
            double proslujenoSumB = proslujenoB * 5;

            double nagradiB = Double.parseDouble(b5.getText().replace(',', '.'));
            double globiB = Double.parseDouble(b6.getText().replace(',', '.'));

            double resultB = (dejSumB + otpuskSumB + praznichniSumB + proslujenoSumB + nagradiB) - globiB;

            this.c1.setText(resultB + "");
        } catch (Exception e) {
            this.c1.setText("Error");
            // Прозореца за грешка
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("error.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image(Main.class.getResourceAsStream("ico.png")));
            stage.setTitle("Грешка");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        }
    }


    // Логиката на бутона "Enter" в първия таб "Старши" - да селектва всяко следващо поле

    public void pressEnterN1(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            n1.isFocused();
            n2.requestFocus();
        }
    }

    public void pressEnterN2(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            n2.isFocused();
            n3.requestFocus();
        }
    }

    public void pressEnterN3(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            n3.isFocused();
            n4.requestFocus();
        }
    }

    public void pressEnterN4(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            n4.isFocused();
            n5.requestFocus();
        }
    }

    public void pressEnterN5(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            n5.isFocused();
            n6.requestFocus();

        }
    }

    public void pressEnterN6(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            n6.isFocused();
            n7.requestFocus();
        }
    }



    // Логиката на бутона "Enter" в втория таб "Атестация" - да селектва всяко следващо поле


    public void pressEnterT1(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            t1.isFocused();
            t2.requestFocus();
        }
    }

    public void pressEnterT2(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            t2.isFocused();
            t3.requestFocus();
        }
    }

    public void pressEnterT3(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            t3.isFocused();
            t4.requestFocus();
        }
    }

    public void pressEnterT4(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            t4.isFocused();
            t5.requestFocus();
        }
    }

    public void pressEnterT5(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            t5.isFocused();
            t6.requestFocus();
        }
    }

    // Логиката на бутона "Enter" в третия таб "Без атестация" - да селектва всяко следващо поле


    public void pressEnterB1(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            b1.isFocused();
            b2.requestFocus();
        }
    }

    public void pressEnterB2(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            b2.isFocused();
            b3.requestFocus();
        }
    }

    public void pressEnterB3(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            b3.isFocused();
            b4.requestFocus();
        }
    }

    public void pressEnterB4(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            b4.isFocused();
            b5.requestFocus();
        }
    }

    public void pressEnterB5(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            b5.isFocused();
            b6.requestFocus();
        }
    }


    // Логиката на бутона "Enter" в четвъртия таб "Колко трябва да взема в плик" - да селектва всяко следващо поле


    public void pressEnterC1(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            c1.isFocused();
            c2.requestFocus();
        }
    }

    public void pressEnterC2(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            c2.isFocused();
            c3.requestFocus();
        }
    }

    public void pressEnterC3(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            c3.isFocused();
            c4.requestFocus();
        }
    }

    // Логиката на бутона "Опитай отново" от прозореца за грешка

    public void tryAgain(ActionEvent actionEvent) {
        Stage stage = (Stage) bottomTry.getScene().getWindow();
        stage.close();
    }
}

