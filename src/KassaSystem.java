
import java.awt.*;
import java.util.Locale;
import javax.swing.*;

public class KassaSystem extends JFrame {

        // Skapar en instans av product-klassen för att hålla reda på varor och priser
    private final product products = new product();

    private JLabel totalText;
    private JLabel matbordText;
    private JLabel matstolarText;
    private JLabel sangText;
    private  JLabel soffaText;
    private JLabel maddrassText;

    // Här börjar vi skapa fönstret
    public KassaSystem() {

        setTitle("JYSK kassasystem");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15,15));

        // hur kassasystemet ska se ut,färger text
        JLabel rubrik = new JLabel("Välkommen till JYSK!");
        rubrik.setFont(new Font("Arial", Font.BOLD, 24));
        JPanel toppPanel = new JPanel();
        toppPanel.setBackground(new Color(0,51,102));
        rubrik.setForeground(Color.WHITE);
        toppPanel.add(rubrik);
        add(toppPanel, BorderLayout.NORTH);

        JPanel varaPanel = new JPanel();
        varaPanel.setLayout(new GridLayout(0,2,10,10));
        varaPanel.setBorder(
                BorderFactory.createTitledBorder("Varor")
        );

        JPanel hogerPanel = new JPanel();
        hogerPanel.setLayout(
                new BoxLayout(hogerPanel, BoxLayout.Y_AXIS)
        );


        JPanel varukorgPanel = new JPanel();

        varukorgPanel.setLayout(
                new BoxLayout(varukorgPanel, BoxLayout.Y_AXIS)
        );

        varukorgPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Din varukorg"),
                        BorderFactory.createEmptyBorder(5, 5, 10, 5)
                )
        );

        // Knapp för Varor/köpa/massa annat roligt!
        ObjectButton matbordknapp = new ObjectButton("Lägg till Matbord");
        ObjectButton matstolKnapp = new ObjectButton("Lägg till Matstol");
        ObjectButton sangKnapp = new ObjectButton("Lägg till en säng");
        ObjectButton soffaKnapp = new ObjectButton("Lägg till en soffa");
        ObjectButton maddrassKnapp = new ObjectButton("lägg till en maddrass");
        JButton taBortmatstolKnapp = new JButton("Ta bort matstol");
        JButton taBortmatbordKnapp = new JButton("Ta bort matbord");
        JButton taBortsangKnapp = new JButton("Ta bort säng");
        JButton taBortsoffaKnapp = new JButton("Ta bort soffa");
        JButton taBortmadrassKnapp = new JButton("Ta bort madrass");


        JButton tomKopKnapp = new JButton("Töm köp");
        tomKopKnapp.setBackground(new Color(183, 28, 28));
        tomKopKnapp.setForeground(Color.WHITE);
        tomKopKnapp.setFont(new Font("Arial", Font.BOLD, 14));
        tomKopKnapp.setFocusPainted(false);

        JButton betalaKnapp = new JButton("Betala");
        betalaKnapp.setBackground(new Color(46, 125, 50));
        betalaKnapp.setForeground(Color.WHITE);
        betalaKnapp.setFont(new Font("Arial", Font.BOLD, 14));
        betalaKnapp.setFocusPainted(false);

        JPanel kassaPanel = new JPanel();
        kassaPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JPanel taBortPanel = new JPanel();
        taBortPanel.setLayout(
                new GridLayout(0, 1, 5, 5)
        );
        taBortPanel.setBorder(
                BorderFactory.createTitledBorder("Ta bort varor")
        );

        taBortPanel.add(taBortmatbordKnapp);
        taBortPanel.add(taBortmatstolKnapp);
        taBortPanel.add(taBortsangKnapp);
        taBortPanel.add(taBortsoffaKnapp);
        taBortPanel.add(taBortmadrassKnapp);


        kassaPanel.add(betalaKnapp);
        kassaPanel.add(tomKopKnapp);


        matbordText = new JLabel();
        matbordText.setFont(new Font("Arial", Font.PLAIN, 14));

        matstolarText = new JLabel();
        matstolarText.setFont(new Font("Arial", Font.PLAIN, 14));

        sangText = new JLabel();
        sangText.setFont(new Font("Arial", Font.PLAIN, 14));

        soffaText = new JLabel();
        soffaText.setFont(new Font("Arial", Font.PLAIN, 14));

        maddrassText = new JLabel();
        maddrassText.setFont(new Font("Arial", Font.PLAIN, 14));


        totalText = new JLabel();


        uppdateraTotal();
        // products. är tillgång till variablerna i product.java, t.ex. antalMatBord och matbordPris
        matstolKnapp.addActionListener(e -> {
            products.antalMatStolar++;
            uppdateraTotal();
        });

        matbordknapp.addActionListener(e -> {
            products.antalMatBord++;
            uppdateraTotal();
        });

        taBortmatstolKnapp.addActionListener(e-> {
            if (products.antalMatStolar > 0){
                products.antalMatStolar--;
                uppdateraTotal();
            }
        });

        taBortmatbordKnapp.addActionListener(e ->{
            if(products.antalMatBord > 0){
                products.antalMatBord--;
                uppdateraTotal();
            }
        });

        taBortsangKnapp.addActionListener(e ->{
            if(products.antalsang > 0){
                products.antalsang--;
                uppdateraTotal();
            }
        });

        taBortsoffaKnapp.addActionListener(e ->{
            if(products.antalsoffa > 0){
                products.antalsoffa--;
                uppdateraTotal();
            }
        });

        taBortmadrassKnapp.addActionListener(e ->{
            if(products.antalmadrass > 0){
                products.antalmadrass--;
                uppdateraTotal();
            }
        });
        tomKopKnapp.addActionListener(e ->{

            products.antalMatBord = 0;
            products.antalMatStolar = 0;
            products.antalsoffa = 0;
            products.antalmadrass = 0;
            products.antalsang = 0;

            uppdateraTotal();

            JOptionPane.showMessageDialog(
                    this,
                    "Varukorgen har tömts!",
                    "Töm köp",
                    JOptionPane.INFORMATION_MESSAGE
            );



        });
        sangKnapp.addActionListener(e->{
            products.antalsang++;
            uppdateraTotal();

        });

        soffaKnapp.addActionListener(e->{
            products.antalsoffa++;
            uppdateraTotal();
        });

        maddrassKnapp.addActionListener(e->{
            products.antalmadrass++;
            uppdateraTotal();
        });

        betalaKnapp.addActionListener(e -> {

            double summaMatbord = products.antalMatBord * products.matbordPris;
            double summaMatstolar = products.antalMatStolar * products.matstolarPris;

            double summaSoffor = products.antalsoffa * products.soffaPris;
            double summaSangar = products.antalsang * products.sangPris;
            double summamadrass = products.antalmadrass * products.madrassPris;

            double total = summaMatbord + summaMatstolar +
                    summaSangar + summaSoffor + summamadrass;


            if (total <= 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Du har inte lagt till några produkter!",
                        "Tomt köp",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            // Fråga hur mycket kunden betalar
            String betalningText = JOptionPane.showInputDialog(
                    this,
                    "Att betala: " + String.format(
                            java.util.Locale.forLanguageTag("sv-SE"),
                            "%.2f", total
                    ) + " kr\nHur mycket betalar kunden?"
            );

            if (betalningText == null) {
                return;
            }

            double betalat;

            try {
                betalat = Double.parseDouble(
                        betalningText.trim().replace(',', '.')
                );
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Skriv ett giltigt belopp, exempelvis 500 eller 500,00.",
                        "Felaktigt belopp",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            // Kontrollera betalningen i ören
            long totalOren = Math.round(total * 100);
            long betalatOren = Math.round(betalat * 100);

            if (betalatOren < totalOren) {
                JOptionPane.showMessageDialog(
                        this,
                        "Kunden har betalat för lite!",
                        "Otillräcklig betalning",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            double vaxel = (betalatOren - totalOren) / 100.0;

            // Skapa kvittot
            StringBuilder kvitto = new StringBuilder();
            kvitto.append("JYSK - KVITTO\n\n");

            if (products.antalMatBord > 0) {
                kvitto.append(String.format(
                        java.util.Locale.forLanguageTag("sv-SE"),
                        "Matbord: %d st - %.2f kr\n",
                        products.antalMatBord, summaMatbord
                ));
            }

            if (products.antalMatStolar > 0) {
                kvitto.append(String.format(
                        java.util.Locale.forLanguageTag("sv-SE"),
                        "Matstolar: %d st - %.2f kr\n",
                        products.antalMatStolar, summaMatstolar
                ));
            }

            if (products.antalsoffa > 0) {
                kvitto.append(String.format(
                        Locale.forLanguageTag("sv-SE"),
                        "Soffa: %d st - %.2f kr\n",
                        products.antalsoffa, products.antalsoffa * products.soffaPris
                ));
            }

            if (products.antalsang > 0) {
                kvitto.append(String.format(
                        Locale.forLanguageTag("sv-SE"),
                        "Säng: %d st - %.2f kr \n",
                        products.antalsang, products.antalsang * products.sangPris
                ));
            }

            if (products.antalmadrass > 0) {
                kvitto.append(String.format(
                        Locale.forLanguageTag("sv-SE"),
                        "Madrass: %d st - %.2f kr\n",
                        products.antalmadrass, products.antalmadrass * products.madrassPris
                ));
            }


            kvitto.append(String.format(
                    java.util.Locale.forLanguageTag("sv-SE"),
                    "\nTOTALT: %.2f kr\nBetalat: %.2f kr\n" +
                            "Växel tillbaka: %.2f kr\n\nTack för ditt köp!",
                    total, betalatOren / 100.0, vaxel
            ));

            // Visa kvittot
            JOptionPane.showMessageDialog(
                    this,
                    kvitto.toString(),
                    "Kvitto",
                    JOptionPane.INFORMATION_MESSAGE
            );

            products.antalMatBord = 0;
            products.antalMatStolar = 0;
            products.antalsang = 0;
            products.antalmadrass = 0;
            products.antalsoffa = 0;

            uppdateraTotal();
        });

// finare rader i kassa systemet

        varaPanel.add(matbordknapp);
        varaPanel.add(matstolKnapp);
        varaPanel.add(sangKnapp);
        varaPanel.add(soffaKnapp);
        varaPanel.add(maddrassKnapp);

        add(varaPanel, BorderLayout.CENTER);
        add(kassaPanel, BorderLayout.SOUTH);

        varukorgPanel.add(matbordText);
        varukorgPanel.add(Box.createVerticalStrut(10));

        varukorgPanel.add(matstolarText);
        varukorgPanel.add(Box.createVerticalStrut(10));

        varukorgPanel.add(sangText);
        varukorgPanel.add(Box.createVerticalStrut(10));

        varukorgPanel.add(soffaText);
        varukorgPanel.add(Box.createVerticalStrut(10));

        varukorgPanel.add(maddrassText);
        varukorgPanel.add(Box.createVerticalStrut(10));

        varukorgPanel.add(totalText);
        varukorgPanel.add(Box.createVerticalStrut(10));


        hogerPanel.add(varukorgPanel);
        hogerPanel.add(taBortPanel);
        add(hogerPanel, BorderLayout.EAST);
    }

    private void uppdateraTotal(){
        double summaMatbord = products.antalMatBord * products.matbordPris;
        double summaMatstolar = products.antalMatStolar * products.matstolarPris;
        double summaSanger = products.antalsang * products.sangPris;
        double summaSoffor = products.antalsoffa * products.soffaPris;
        double summaMadrasser = products.antalmadrass * products.madrassPris;

        double total = summaMatbord + summaMatstolar + summaMadrasser +
                summaSoffor + summaSanger;

        matbordText.setText(
                String.format(
                        Locale.forLanguageTag("sv-SE"),
                        "Matbord: %d st - %.2f kr",
                        products.antalMatBord,
                        summaMatbord
                )
        );

        matstolarText.setText(
                String.format(
                        Locale.forLanguageTag("sv-SE"),
                        "Matstolar: %d st - %.2f kr",
                        products.antalMatStolar,
                        summaMatstolar
                )
        );

        sangText.setText(
                String.format(
                        Locale.forLanguageTag("sv-SE"),
                        "Säng: %d st - %.2f kr",
                        products.antalsang,
                        summaSanger
                )
        );




        soffaText.setText(
                String.format(
                        Locale.forLanguageTag("sv-SE"),
                        "Soffa: %d st - %.2f kr",
                        products.antalsoffa,
                        summaSoffor
                )
        );

        maddrassText.setText(
                String.format(
                        Locale.forLanguageTag("sv-SE"),
                        "Madrass: %d st - %.2f kr",
                        products.antalmadrass,
                        summaMadrasser
                )
        );

        totalText.setText(
                String.format(
                        Locale.forLanguageTag("sv-SE"),
                        "TOTALT: %.2f kr",
                        total
                )
        );

        totalText.setFont(new Font("Arial", Font.BOLD, 18));
        totalText.setForeground(new Color(0, 51, 102));

    }

    public static void main(String[] args){

        SwingUtilities.invokeLater(() -> {
            KassaSystem kassa = new KassaSystem();
            kassa.setVisible(true);
        });

    }
}
