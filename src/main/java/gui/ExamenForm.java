package gui;

import controller.ExamenController;
import model.Candidat;
import model.Examen;

import javax.swing.*;
import java.util.List;

public class ExamenForm extends  JFrame{
    private JList list1;
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton adaugaButton;

    private Candidat candidat;

    private DefaultListModel<Examen> model;
    public ExamenForm(Candidat candidat) {
        this.candidat = candidat;

        model = new DefaultListModel<Examen>();
        list1.setModel(model);
        afisExamene();
        adaugaButton.addActionListener(ev->adaugaExamene());
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void afisExamene(){
        List<Examen> examene = ExamenController.getInstance().findByCandidat(candidat.getId());

        model.clear();

        examene.forEach(c->model.addElement(c));

    }
    private void adaugaExamene(){
        int nota = Integer.parseInt(textField1.getText());
        System.out.println(candidat.getId());
        Examen examen = new Examen( 0,nota,candidat.getId());
        System.out.println(examen);
        boolean rez = ExamenController.getInstance().create(examen);

        if(rez){
            afisExamene();
        }else{
            JOptionPane.showMessageDialog(null,"Eroare la adaugare");
        }

        textField1.setText("");
    }
}
