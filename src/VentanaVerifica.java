import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;

public class VentanaVerifica extends JFrame {
    JLabel labelPlaca;
    JTextField textFieldPlaca;
    JButton buttonVerificar;
    JLabel labelOK;
    boolean circula;
    //JLabel labelError;
    //datos
    int placa[];
    // Array con los dias de la semana
    // El dia de la semana inicia en el 1 mientras que el array empieza en el 0
    String[] stringDays = new String[]{"Domingo", "Lunes", "Martes",
            "Miercoles", "Jueves", "Viernes", "Sabado"};

    public VentanaVerifica() {

        super.setTitle("Verificador v1.0 " + obtenerDia());
        labelPlaca = new JLabel("Placa: ");
        textFieldPlaca = new JTextField(10);
        buttonVerificar = new JButton("Verificar");
        labelOK=new JLabel("");
        setLayout(new FlowLayout());
        setSize(500, 500);
        add(labelPlaca);
        add(textFieldPlaca);
        add(buttonVerificar);
        buttonVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                verificarPlaca();
            }
        });
        setVisible(true);
    }

    private void verificarPlaca() {
        int numero;
        numero = getPrimerDigito(textFieldPlaca.getText());
        String diaActual = obtenerDia();
        circula = false;

        switch (diaActual) {
            case "Lunes": {
                if (numero == 0 || numero == 1) ;
                circula = true;
                break;
            }
            case "Martes": {
                if (numero == 2 || numero == 3) ;
                circula = true;
                break;
            }
            case "Miercoles": {
                if (numero == 4 || numero == 5) ;
                circula = true;
                break;
            }
            case "Jueves": {
                if (numero == 6 || numero == 7) ;
                circula = true;
                break;
            }
            case "Viernes": {
                if (numero == 8 || numero == 9) ;
                circula = true;
                break;
            }
            default:    circula=false;
                break;
        }
        if (circula) {
            labelOK.setText("Hoy Circulas");
            add(labelOK);
        } else {

            labelOK.setText("Hoy NO Circulas");
            add(labelOK);
        }
        setVisible(true);
    }

    private int getParteNumerica(String placa) {
        int res = 0;
        for (int indice = 0; indice < placa.length(); indice++) {
            char c = placa.charAt(indice);
            if (c >= '0' && c <= '9') {
                res = res * 10 + Character.getNumericValue(c);
                System.out.println(res);
            }
        }
        System.out.println(res);
        return res;
    }

    private int getPrimerDigito(String placa) {
        int res = 0;
        for (int indice = 0; indice < placa.length(); indice++) {
            char c = placa.charAt(indice);
            if (c >= '0' && c <= '9') {
                res = res * 10 + Character.getNumericValue(c);
                System.out.println("primer digito" + res);
                return res;
            }
        }
        System.out.println(res);
        return res;
    }

    private String obtenerDia() {
        String diaActual;
        Calendar hoy = Calendar.getInstance();
        System.out.println("Fecha actual : " + (hoy.get(Calendar.MONTH) + 1) +
                "-" + hoy.get(Calendar.DATE) + "-" + hoy.get(Calendar.YEAR));
        System.out.println("Hoy es : " + stringDays[hoy.get(Calendar.DAY_OF_WEEK) - 1]);
        diaActual = stringDays[hoy.get(Calendar.DAY_OF_WEEK) - 1];
        return diaActual;
    }
}
