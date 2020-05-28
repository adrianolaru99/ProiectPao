package gui;

import controller.CandidatController;
import model.Candidat;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class CandidatForm extends JFrame {
    private JList list1;
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton adaugaButton;

    private DefaultListModel<Candidat> model;
    public  CandidatForm(){
        model = new DefaultListModel<>();
        afisPersoane();
        list1.setModel(model);
        adaugaButton.addActionListener(ev->adaugaCandidat());

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onMouseClickedForList(e);
            }
        });
    }

    private void onMouseClickedForList(MouseEvent e){
        boolean isItemSelected = list1.getSelectedValue() !=null;

        if(isItemSelected && e.getButton() == MouseEvent.BUTTON1
         &&e.getClickCount()==2
        ){



            Candidat selected = (Candidat) list1.getSelectedValue();
            new ExamenForm(selected);
        }
        if(isItemSelected && e.getButton() == MouseEvent.BUTTON3
                &&e.getClickCount()==2
        ){



            Candidat selected = (Candidat) list1.getSelectedValue();
            boolean rez = CandidatController.getInstance().delete(selected.getId());

            if(rez){
                afisPersoane();
            }
        }
    }

    private void afisPersoane(){
        List<Candidat> candidati = CandidatController.getInstance().findAll();
        model.clear();
        candidati.forEach(c->model.addElement(c));

    }

    private void adaugaCandidat(){
        String nume = textField1.getText();
        Candidat c = new Candidat(0,nume);

        boolean rez = CandidatController.getInstance().create(c);

        if(rez){
            afisPersoane();
        }else{
            JOptionPane.showMessageDialog(null,"Numele exista deja");
            textField1.setText("");
        }
    }
}
