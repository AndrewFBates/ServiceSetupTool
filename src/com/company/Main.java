//imports
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

import static java.lang.Integer.parseInt;

// Main Class is a basic menu, with allows for other classes to be created and used to complete functions
public class Main implements ActionListener {

    // Vars
    private String globalIP = "No Ipv4 Global";
    private String localIP = "No Ipv4 Local";
    private String defaultGateway = "No Ipv4 Gateway";
    private String servicePort = "No Port";
    // Connection status vars
    boolean connectionPing = false;
    boolean connectionStatus = false;
    boolean connectionUDP = false;

    // GUI elements
    // Welcome page
    private JFrame frame;
    private JPanel welcomePanel;
    private JLabel welcomeLabel;
    private JLabel welcome1;
    private JLabel welcome2;
    private JLabel welcome3;
    private JLabel welcome4;
    private JLabel welcomeTextLabel;
    private JButton welcomeInfoButton;
    private JButton welcomeMenuButton;

    // Main menu page
    private JPanel mainMenuPanel;
    private JLabel mainMenuLabel;
    private JLabel mainMenuTextLabel;
    private JButton mainMenuSetupButton;
    private JButton mainMenuMonitorButton;
    private JButton mainMenuStatsButton;
    private JButton mainMenuSettingsButton;
    private JButton mainMenuHelpButton;

    // Setup start page
    private JPanel serviceSetupStartPanel;
    private JLabel serviceSetupStartLabel;
    private JLabel serviceSetupStart1;
    private JLabel serviceSetupStart2;
    private JLabel serviceSetupStart3;
    private JLabel serviceSetupStart4;
    private JLabel serviceSetupStart5;
    private JButton serviceSetupStartButton;
    private JButton serviceSetupQuitToMenuButton;
    private JButton serviceSetupStartInfoButton;

    // Setup settings page
    private JPanel serviceSettingsPanel;
    private JLabel serviceSettingsLabel;
    private JLabel serviceSettings1;
    private JLabel serviceSettings2;
    private JLabel serviceSettings3;
    private JLabel serviceSettings4;
    private JLabel serviceSettings5;
    private JLabel serviceSettingsTextLabel;
    private JLabel serviceSettingsIpLocal;
    private JLabel serviceSettingsIpLocalText;
    private JTextField serviceSettingsIpLocalTextField;
    private JLabel serviceSettingsIpGlobal;
    private JLabel serviceSettingsIpGlobalText;
    private JTextField serviceSettingsIpGlobalTextField;
    private JLabel serviceSettingsIpGateway;
    private JLabel serviceSettingsIpGatewayText;
    private JTextField serviceSettingsIpGatewayTextField;
    private JLabel serviceSettingsPort;
    private JLabel serviceSettingsPortText;
    private JTextField serviceSettingsPortTextField;
    private JLabel serviceSettingsError;
    private JButton serviceSettingsConfirmButton;
    private JButton serviceSettingsRouterButton;
    private JButton serviceSettingsInfoButton;
    private JButton serviceSettingsQuitToMenuButton;

    // Setup testing connection page
    private JPanel testingServicePanel;
    private JLabel testingServiceLabel;
    private JLabel testingServiceLine1;
    private JLabel testingServiceLine2;
    private JLabel testingServiceLine3;
    private JLabel testingServiceLine4;
    private JLabel testingServiceLine5;
    private JButton testingServiceButton;
    private JButton testingServiceSettingsButton;
    private JButton testingServiceInfoButton;
    private JButton testingServiceQuitButton;

    // Monitoring setup page
    private JPanel monitoringStartPanel;
    private JLabel monitoringStartLabel;
    private JLabel monitoringStartText1;
    private JLabel monitoringStartText2;
    private JLabel monitoringStartIpAddressText;
    private JLabel monitoringStartIPAddress;
    private JTextField monitoringStartIPAddressField;
    private JLabel monitoringStartPortText;
    private JLabel monitoringStartPort;
    private JTextField monitoringStartPortField;
    private JButton monitoringFiltersButton;
    private JButton monitoringFiltersInfoButton;
    private JButton monitoringFiltersQuitButton;

    // Monitoring Filters Page
    private JPanel monitoringFiltersPanel;
    private JLabel monitoringFiltersText;
    private JLabel monitoringFiltersLabel;
    private JLabel monitoringFilter1;
    private JLabel monitoringFilter2;
    private JButton monitoringChangeFilters;
    private JButton monitoringOpenWireshark;
    private JButton monitoringInfoButton;
    private JButton monitoringQuitButton;

    // Settings Page
    private JPanel settingsPanel;
    private JLabel settingsLabel;
    private JLabel settingsText1;
    private JLabel settingsWiresharkDirectoryText;
    private JLabel settingsWiresharkDirectory;
    private JFileChooser settingsWiresharkDirectoryFile;
    private JButton settingsInfoButton;
    private JButton settingsQuitButton;
    private JButton settingSaveButton;

    // GUI Constructor
    public Main() {

        // Frame
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Service Setup Tool");
        frame.setSize(705, 500);

        // GUI welcome page
            // START
            welcomePanel = new JPanel();
            welcomePanel.setLayout(null);
            frame.add(welcomePanel);
            // Labels
            // Title
            welcomeLabel = new JLabel("Welcome to the Service Setup Tool");
            welcomeLabel.setFont(new Font("", Font.BOLD, 18));
            welcomeLabel.setBounds(10, 10, 680, 40);
            // Text
            welcome1 = new JLabel("This tool was designed to help setup a service (specifically for gaming, but will work for other services too). The");
            welcome1.setBounds(10, 50, 680, 20);
            welcome2 = new JLabel("service setup tool can work by itself, but if you wish to monitor traffic, Wireshark will need to be installed. The text on");
            welcome2.setBounds(10, 70, 680, 20);
            welcome3 = new JLabel("this application is rather simple, but if you wish to see more, each page has a \"Info\" button available in the top-right");
            welcome3.setBounds(10, 90, 680, 20);
            welcome4 = new JLabel("that will open a web page with more information.");
            welcome4.setBounds(10, 110, 680, 20);
            welcomeTextLabel = new JLabel("Press the Menu button to continue.");
            welcomeTextLabel.setBounds(10, 200, 680, 20);
            // Buttons
            // Info
                welcomeInfoButton = new JButton("Info");
                welcomeInfoButton.setBounds(620, 10, 60,40);
                welcomeInfoButton.addActionListener(this);
            // Main Menu
                welcomeMenuButton = new JButton("Open Main Menu");
                welcomeMenuButton.setBounds(10, 410, 200,40);
                welcomeMenuButton.addActionListener(this);
            // Add
            welcomePanel.add(welcomeLabel);
            welcomePanel.add(welcomeTextLabel);
            welcomePanel.add(welcome1);
            welcomePanel.add(welcome2);
            welcomePanel.add(welcome3);
            welcomePanel.add(welcome4);
            welcomePanel.add(welcomeInfoButton);
            welcomePanel.add(welcomeMenuButton);

        // Main menu page
            // START
            mainMenuPanel = new JPanel();
            mainMenuPanel.setLayout(null);
            // Labels
            // Title
            mainMenuLabel = new JLabel("Service Setup Tool Main Menu");
            mainMenuLabel.setFont(new Font("", Font.BOLD, 18));
            mainMenuLabel.setBounds(10,10,680,35);
            // Text
            mainMenuTextLabel = new JLabel("Select Setup to begin service setup. Select Monitoring to capture traffic. Stats and Settings unavailable.");
            mainMenuTextLabel.setBounds(10, 50, 680, 20);
            // Buttons
            // Info
                mainMenuHelpButton = new JButton("Info");
                mainMenuHelpButton.setBounds(620, 10, 60,40);
                mainMenuHelpButton.addActionListener(this);
            // Service Setup
                mainMenuSetupButton = new JButton("Service Setup");
                mainMenuSetupButton.setBounds(10,410,160,40);
                mainMenuSetupButton.addActionListener(this);
            // Monitor
                mainMenuMonitorButton = new JButton("Monitoring Mode");
                mainMenuMonitorButton.setBounds(180,410,160,40);
                mainMenuMonitorButton.addActionListener(this);
            // Statistics
                mainMenuStatsButton = new JButton("Statistics");
                mainMenuStatsButton.setBounds(350,410,160,40);
                mainMenuStatsButton.addActionListener(this);
            // Statistics
                mainMenuSettingsButton = new JButton("Settings");
                mainMenuSettingsButton.setBounds(520,410,160,40);
                mainMenuSettingsButton.addActionListener(this);
            // Add
            mainMenuPanel.add(mainMenuLabel);
            mainMenuPanel.add(mainMenuTextLabel);
            mainMenuPanel.add(mainMenuSetupButton);
            mainMenuPanel.add(mainMenuMonitorButton);
            mainMenuPanel.add(mainMenuStatsButton);
            mainMenuPanel.add(mainMenuSettingsButton);
            mainMenuPanel.add(mainMenuHelpButton);

        // Service-setup page
            // START
            serviceSetupStartPanel = new JPanel();
            serviceSetupStartPanel.setLayout(null);
            // Title
            serviceSetupStartLabel = new JLabel("Service Setup Guide");
            serviceSetupStartLabel.setFont(new Font("", Font.BOLD, 18));
            serviceSetupStartLabel.setBounds(10,10,680,35);
            // Text
            serviceSetupStart1 = new JLabel("This is the service setup guide. This tool will help you configure your port-fowarding and");
            serviceSetupStart1.setBounds(10, 50, 680, 20);
            serviceSetupStart2 = new JLabel("test the connectivity of your service. If you'd like to learn more about internet traffic");
            serviceSetupStart2.setBounds(10, 70, 680, 20);
            serviceSetupStart3 = new JLabel("and connections, click the \"Info\" button. Its HIGHLY recommended that you know the basics of");
            serviceSetupStart3.setBounds(10, 90, 680, 20);
            serviceSetupStart4 = new JLabel("network traffic and the potential threat port-fowarding opens your network to.");
            serviceSetupStart4.setBounds(10, 110, 680, 20);
            serviceSetupStart5 = new JLabel("");
            serviceSetupStart5.setBounds(10, 130, 680, 20);
            // Buttons
            // Start
                serviceSetupStartButton = new JButton("Start Setup");
                serviceSetupStartButton.setBounds(10,410,160,40);
                serviceSetupStartButton.addActionListener(this);
            // Info
                serviceSetupStartInfoButton = new JButton("Info");
                serviceSetupStartInfoButton.setBounds(620, 10, 60,40);
                serviceSetupStartInfoButton.addActionListener(this);
            // Quit
                serviceSetupQuitToMenuButton = new JButton("Quit to Menu");
                serviceSetupQuitToMenuButton.setBounds(520,410,160,40);
                serviceSetupQuitToMenuButton.setBackground(Color.RED);
                serviceSetupQuitToMenuButton.addActionListener(this);
            // ADD
            serviceSetupStartPanel.add(serviceSetupStartLabel);
            serviceSetupStartPanel.add(serviceSetupStart1);
            serviceSetupStartPanel.add(serviceSetupStart2);
            serviceSetupStartPanel.add(serviceSetupStart3);
            serviceSetupStartPanel.add(serviceSetupStart4);
            serviceSetupStartPanel.add(serviceSetupStart5);
            serviceSetupStartPanel.add(serviceSetupStartButton);
            serviceSetupStartPanel.add(serviceSetupStartInfoButton);
            serviceSetupStartPanel.add(serviceSetupQuitToMenuButton);

        // Service-setup setting page
            // START
            serviceSettingsPanel = new JPanel();
            serviceSettingsPanel.setLayout(null);
            // Title
            serviceSettingsLabel = new JLabel("Service Connection Settings");
            serviceSettingsLabel.setFont(new Font("", Font.BOLD, 18));
            serviceSettingsLabel.setBounds(10,10,680,35);
            // Text
            serviceSettings1 = new JLabel("The Service Setup Tool should be able to identify the correct IP Addresses required to setup your service. You will");
            serviceSettings1.setBounds(10, 50, 680, 20);
            serviceSettings2 = new JLabel("however need to enter your service's port number and configure your home router for port-fowarding to allow for");
            serviceSettings2.setBounds(10, 70, 680, 20);
            serviceSettings3 = new JLabel("internet connections. Click \"Open Router\" to open your router's login page. From there you can setup port-fowarding.");
            serviceSettings3.setBounds(10, 90, 680, 20);
            serviceSettings4 = new JLabel("If you need help or want to know more, click the \"Info\" button.");
            serviceSettings4.setBounds(10, 110, 680, 20);
            serviceSettings5 = new JLabel("");
            serviceSettings5.setBounds(10, 130, 680, 20);
            serviceSettingsTextLabel = new JLabel("(leave blank for no change)");
            serviceSettingsTextLabel.setBounds(400, 175, 680, 20);
            serviceSettingsError = new JLabel("");
            serviceSettingsError.setBounds(10, 300, 680, 20);
            // Local IP
                serviceSettingsIpLocalText = new JLabel("Ipv4 Local:");
                serviceSettingsIpLocalText.setBounds(10, 200, 150, 20);
                serviceSettingsIpLocal = new JLabel("No Ipv4 Local");
                serviceSettingsIpLocal.setBounds(170, 200, 150, 20);
                serviceSettingsIpLocalTextField = new JTextField(10);
                serviceSettingsIpLocalTextField.setBounds(330, 200, 300, 20);
            // Global IP
                serviceSettingsIpGlobalText = new JLabel("Ipv4 Global:");
                serviceSettingsIpGlobalText.setBounds(10, 225, 150, 20);
                serviceSettingsIpGlobal = new JLabel("No Ipv4 Global");
                serviceSettingsIpGlobal.setBounds(170, 225, 300, 20);
                serviceSettingsIpGlobalTextField = new JTextField(10);
                serviceSettingsIpGlobalTextField.setBounds(330, 225, 300, 20);
            // Gateway IP
                serviceSettingsIpGatewayText = new JLabel("Ipv4 Gateway:");
                serviceSettingsIpGatewayText.setBounds(10, 250, 150, 20);
                serviceSettingsIpGateway = new JLabel("No Ipv4 Gateway");
                serviceSettingsIpGateway.setBounds(170, 250, 150, 20);
                serviceSettingsIpGatewayTextField = new JTextField(10);
                serviceSettingsIpGatewayTextField.setBounds(330, 250, 300, 20);
            // Port
                serviceSettingsPortText = new JLabel("Port:");
                serviceSettingsPortText.setBounds(10, 275, 150, 20);
                serviceSettingsPort = new JLabel("No Port");
                serviceSettingsPort.setBounds(170, 275, 150, 20);
                serviceSettingsPortTextField = new JTextField(10);
                serviceSettingsPortTextField.setBounds(330, 275, 300, 20);
            // Buttons
            // Confirm
                serviceSettingsConfirmButton = new JButton("Confirm Settings");
                serviceSettingsConfirmButton.setBounds(10,410,160,40);
                serviceSettingsConfirmButton.addActionListener(this);
            // Router Settings
                serviceSettingsRouterButton = new JButton("Open Router");
                serviceSettingsRouterButton.setBounds(180,410,160,40);
                serviceSettingsRouterButton.addActionListener(this);
            // Info
                serviceSettingsInfoButton = new JButton("Info");
                serviceSettingsInfoButton.setBounds(620, 10, 60,40);
                serviceSettingsInfoButton.addActionListener(this);
            // Quit
                serviceSettingsQuitToMenuButton = new JButton("Quit to Menu");
                serviceSettingsQuitToMenuButton.setBounds(520,410,160,40);
                serviceSettingsQuitToMenuButton.setBackground(Color.RED);
                serviceSettingsQuitToMenuButton.addActionListener(this);
            // ADD
            serviceSettingsPanel.add(serviceSettingsLabel);
            serviceSettingsPanel.add(serviceSettings1);
            serviceSettingsPanel.add(serviceSettings2);
            serviceSettingsPanel.add(serviceSettings3);
            serviceSettingsPanel.add(serviceSettings4);
            serviceSettingsPanel.add(serviceSettings5);
            serviceSettingsPanel.add(serviceSettingsTextLabel);
            serviceSettingsPanel.add(serviceSettingsError);
            // Local IP
            serviceSettingsPanel.add(serviceSettingsIpLocal);
            serviceSettingsPanel.add(serviceSettingsIpLocalText);
            serviceSettingsPanel.add(serviceSettingsIpLocalTextField);
            // Global IP
            serviceSettingsPanel.add(serviceSettingsIpGlobal);
            serviceSettingsPanel.add(serviceSettingsIpGlobalText);
            serviceSettingsPanel.add(serviceSettingsIpGlobalTextField);
            // Gateway IP
            serviceSettingsPanel.add(serviceSettingsIpGateway);
            serviceSettingsPanel.add(serviceSettingsIpGatewayText);
            serviceSettingsPanel.add(serviceSettingsIpGatewayTextField);
            // Port
            serviceSettingsPanel.add(serviceSettingsPort);
            serviceSettingsPanel.add(serviceSettingsPortText);
            serviceSettingsPanel.add(serviceSettingsPortTextField);
            // Buttons
            serviceSettingsPanel.add(serviceSettingsConfirmButton);
            serviceSettingsPanel.add(serviceSettingsRouterButton);
            serviceSettingsPanel.add(serviceSettingsInfoButton);
            serviceSettingsPanel.add(serviceSettingsQuitToMenuButton);

        // Setup testing connection page
        // START
            testingServicePanel = new JPanel();
            testingServicePanel.setLayout(null);
            // Title
            testingServiceLabel = new JLabel("Service Network Connectivity Test");
            testingServiceLabel.setFont(new Font("", Font.BOLD, 18));
            testingServiceLabel.setBounds(10,10,680,35);
            // Text
            testingServiceLine1 = new JLabel("From here you can start a service connectivity test. If it fails, some solutions will be suggested.");
            testingServiceLine1.setBounds(10, 50, 680, 20);
            testingServiceLine2 = new JLabel("(A connection test may take up to 30 seconds)");
            testingServiceLine2.setBounds(10, 90, 680, 20);
            testingServiceLine3 = new JLabel("");
            testingServiceLine3.setBounds(10, 110, 680, 20);
            testingServiceLine4 = new JLabel("");
            testingServiceLine4.setBounds(10, 130, 680, 20);
            testingServiceLine5 = new JLabel("");
            testingServiceLine5.setBounds(10, 150, 680, 20);
            // Buttons
            // Start Test
                testingServiceButton = new JButton("Start Test");
                testingServiceButton.setBounds(10,410,160,40);
                testingServiceButton.addActionListener(this);
            // Connection Settings
                testingServiceSettingsButton = new JButton("Connection Settings");
                testingServiceSettingsButton.setBounds(180,410,160,40);
                testingServiceSettingsButton.addActionListener(this);
            // Info
                testingServiceInfoButton = new JButton("Info");
                testingServiceInfoButton.setBounds(620, 10, 60,40);
                testingServiceInfoButton.addActionListener(this);
            // Quit
                testingServiceQuitButton = new JButton("Quit to Menu");
                testingServiceQuitButton.setBounds(520,410,160,40);
                testingServiceQuitButton.setBackground(Color.RED);
                testingServiceQuitButton.addActionListener(this);
            // Add
            testingServicePanel.add(testingServiceLabel);
            // Text
            testingServicePanel.add(testingServiceLine1);
            testingServicePanel.add(testingServiceLine2);
            testingServicePanel.add(testingServiceLine3);
            testingServicePanel.add(testingServiceLine4);
            testingServicePanel.add(testingServiceLine5);
            // Buttons
            testingServicePanel.add(testingServiceButton);
            testingServicePanel.add(testingServiceSettingsButton);
            testingServicePanel.add(testingServiceInfoButton);
            testingServicePanel.add(testingServiceQuitButton);

        // Monitoring setup page
        // START
            monitoringStartPanel = new JPanel();
            monitoringStartPanel.setLayout(null);
            // Title
            monitoringStartLabel = new JLabel("Monitoring Mode");
            monitoringStartLabel.setFont(new Font("", Font.BOLD, 18));
            monitoringStartLabel.setBounds(10,10,680,35);
            // Text
            monitoringStartText1 = new JLabel("If you have Wireshark installed, this tool will create filters for you to use with it to better monitor");
            monitoringStartText1.setBounds(10, 50, 680, 20);
            monitoringStartText2 = new JLabel("traffic to and from your service. If you'd like to install or learn more about Wireshark, click \"Info\".");
            monitoringStartText2.setBounds(10, 70, 680, 20);
            // Des IP
                monitoringStartIpAddressText = new JLabel("Destination Ipv4:");
                monitoringStartIpAddressText.setBounds(10, 250, 150, 20);
                monitoringStartIPAddress = new JLabel("");
                monitoringStartIPAddress.setBounds(170, 250, 150, 20);
                monitoringStartIPAddressField = new JTextField(10);
                monitoringStartIPAddressField.setBounds(330, 250, 300, 20);
            // Des Port
                monitoringStartPortText = new JLabel("Destination Port:");
                monitoringStartPortText.setBounds(10, 275, 150, 20);
                monitoringStartPort = new JLabel("");
                monitoringStartPort.setBounds(170, 275, 150, 20);
                monitoringStartPortField = new JTextField(10);
                monitoringStartPortField.setBounds(330, 275, 300, 20);
            // Buttons
            // Generate
                monitoringFiltersButton = new JButton("Generate Wireshark Filters");
                monitoringFiltersButton.setBounds(10,410,320,40);
                monitoringFiltersButton.addActionListener(this);
            // Info
                monitoringFiltersInfoButton = new JButton("Info");
                monitoringFiltersInfoButton.setBounds(620, 10, 60,40);
                monitoringFiltersInfoButton.addActionListener(this);
            // Quit
                monitoringFiltersQuitButton = new JButton("Quit to Menu");
                monitoringFiltersQuitButton.setBounds(520,410,160,40);
                monitoringFiltersQuitButton.setBackground(Color.RED);
                monitoringFiltersQuitButton.addActionListener(this);
            // Add
            monitoringStartPanel.add(monitoringStartLabel);
            monitoringStartPanel.add(monitoringStartText1);
            monitoringStartPanel.add(monitoringStartText2);
            // IP
            monitoringStartPanel.add(monitoringStartIpAddressText);
            monitoringStartPanel.add(monitoringStartIPAddress);
            monitoringStartPanel.add(monitoringStartIPAddressField);
            // Port
            monitoringStartPanel.add(monitoringStartPortText);
            monitoringStartPanel.add(monitoringStartPort);
            monitoringStartPanel.add(monitoringStartPortField);
            // Buttons
            monitoringStartPanel.add(monitoringFiltersButton);
            monitoringStartPanel.add(monitoringFiltersInfoButton);
            monitoringStartPanel.add(monitoringFiltersQuitButton);

        // Monitoring Filters Page
        // START
            monitoringFiltersPanel = new JPanel();
            monitoringFiltersPanel.setLayout(null);
            // Title
            monitoringFiltersText = new JLabel("Wireshark Filters");
            monitoringFiltersText.setFont(new Font("", Font.BOLD, 18));
            monitoringFiltersText.setBounds(10,10,680,35);
            // Text
            monitoringFiltersLabel = new JLabel("Here are some filters to use with Wireshark. ");
            monitoringFiltersLabel.setBounds(10, 50, 680, 20);
            // Filters
            monitoringFilter1 = new JLabel("Filter");
            monitoringFilter1.setBounds(10, 90, 680, 20);
            monitoringFilter2 = new JLabel("Filter");
            monitoringFilter2.setBounds(10, 110, 680, 20);
            // Buttons
            // Change Settings
                monitoringChangeFilters = new JButton("Change Settings");
                monitoringChangeFilters.setBounds(10,410,160,40);
                monitoringChangeFilters.addActionListener(this);
            // Open Wireshark
                monitoringOpenWireshark = new JButton("Open Wireshark");
                monitoringOpenWireshark.setBounds(180,410,160,40);
                monitoringOpenWireshark.addActionListener(this);
            // Info
                monitoringInfoButton = new JButton("Info");
                monitoringInfoButton.setBounds(620, 10, 60,40);
                monitoringInfoButton.addActionListener(this);
            // Quit
                monitoringQuitButton = new JButton("Quit to Menu");
                monitoringQuitButton.setBounds(520,410,160,40);
                monitoringQuitButton.setBackground(Color.RED);
                monitoringQuitButton.addActionListener(this);
            // Add
            monitoringFiltersPanel.add(monitoringFiltersText);
            monitoringFiltersPanel.add(monitoringFiltersLabel);
            monitoringFiltersPanel.add(monitoringFilter1);
            monitoringFiltersPanel.add(monitoringFilter2);
            monitoringFiltersPanel.add(monitoringOpenWireshark);
            monitoringFiltersPanel.add(monitoringChangeFilters);
            monitoringFiltersPanel.add(monitoringInfoButton);
            monitoringFiltersPanel.add(monitoringQuitButton);

        // Settings Page
        // START
        settingsPanel = new JPanel();
        settingsPanel.setLayout(null);
        // Title
        settingsLabel = new JLabel("Settings");
        settingsLabel.setFont(new Font("", Font.BOLD, 18));
        settingsLabel.setBounds(10,10,680,35);
        // Text
        settingsText1 = new JLabel("Use the option(s) below to configure your settings (NOT CURRENTLY WORKING)");
        settingsText1.setBounds(10, 50, 680, 20);
        // Wireshark Install Location
        settingsWiresharkDirectoryText = new JLabel("Wireshark Directory");
        settingsWiresharkDirectoryText.setBounds(10, 90, 200, 20);
        settingsWiresharkDirectory = new JLabel("Default Directory");
        settingsWiresharkDirectory.setBounds(220, 90, 200, 20);
        settingsWiresharkDirectoryFile = new JFileChooser("C:\\Program Files\\Wireshark\\Wireshark.exe");
        settingsWiresharkDirectoryFile.setCurrentDirectory(new File(System.getProperty("user.home")));
        settingsWiresharkDirectoryFile.setBounds(450, 90, 240, 20);
        settingsWiresharkDirectoryFile.addActionListener(this);
        // Buttons
        // Save
            settingSaveButton = new JButton("Save Settings");
            settingSaveButton.setBounds(10,410,160,40);
            settingSaveButton.addActionListener(this);
        // Info
            settingsInfoButton = new JButton("Info");
            settingsInfoButton.setBounds(620, 10, 60,40);
            settingsInfoButton.addActionListener(this);
        // Quit
            settingsQuitButton = new JButton("Quit without Saving");
            settingsQuitButton.setBounds(480,410,200,40);
            settingsQuitButton.setBackground(Color.RED);
            settingsQuitButton.addActionListener(this);
        // ADD
        settingsPanel.add(settingsLabel);
        settingsPanel.add(settingsText1);
        settingsPanel.add(settingsWiresharkDirectoryText);
        settingsPanel.add(settingsWiresharkDirectory);
        settingsPanel.add(settingsWiresharkDirectoryFile);
        settingsPanel.add(settingsInfoButton);
        settingsPanel.add(settingSaveButton);
        settingsPanel.add(settingsQuitButton);


        frame.setVisible(true);
    }

    // Main method
    public static void main(String[] args) throws ScriptException, URISyntaxException, IOException {


        // Welcome Page
        new Main();
        // Most actions are handled by the actionPerformed Method, as the Main Method cannot be effected by actionPerformed.
    }

    // Action Listener Method, Required to
    public void actionPerformed(ActionEvent actionEvent) {

        // Check if WelcomeInfo button was clicked. If so, then open Welcome page
        if(actionEvent.getSource() == welcomeInfoButton){
            // Find current directory, then open the welcome html page
            String userDirectory = new File("").getAbsolutePath();
            File htmlFile = new File(userDirectory + "\\Readme.html");
            try {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // mainMenuHelpButton
        if(actionEvent.getSource() == mainMenuHelpButton ){
            // Find current directory, then open the html page
            String userDirectory = new File("").getAbsolutePath();
            File htmlFile = new File(userDirectory + "\\Menu.html");
            try {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // serviceSetupStartInfoButton serviceSettingsInfoButton
        if(actionEvent.getSource() == serviceSetupStartInfoButton ||
           actionEvent.getSource() == serviceSettingsInfoButton){
            // Find current directory, then open the html page
            String userDirectory = new File("").getAbsolutePath();
            File htmlFile = new File(userDirectory + "\\NetworkTraffic.html");
            try {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // testingServiceInfoButton
        if(actionEvent.getSource() == testingServiceInfoButton ){
            // Find current directory, then open the html page
            String userDirectory = new File("").getAbsolutePath();
            File htmlFile = new File(userDirectory + "\\TestServices.html");
            try {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // monitoringFiltersInfoButton monitoringInfoButton
        if(actionEvent.getSource() == monitoringFiltersInfoButton ||
                actionEvent.getSource() == monitoringInfoButton){
            // Find current directory, then open the html page
            String userDirectory = new File("").getAbsolutePath();
            File htmlFile = new File(userDirectory + "\\Wireshark.html");
            try {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // settingsInfoButton
        if(actionEvent.getSource() == settingsInfoButton){
            // Find current directory, then open the html page
            String userDirectory = new File("").getAbsolutePath();
            File htmlFile = new File(userDirectory + "\\Settings.html");
            try {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Check if Menu button was clicked.
        if(actionEvent.getSource() == welcomeMenuButton){
            // Change GUI to menu gui
            frame.setContentPane(mainMenuPanel);
            frame.invalidate();
            frame.validate();
        }

        // Check if ToolInfo button was clicked. If so, then open tool help page
        if(actionEvent.getSource() == mainMenuHelpButton){
            // Find current directory, then open the welcome html page
            String userDirectory = new File("").getAbsolutePath();
            File htmlFile = new File(userDirectory + "\\Welcome.html");
            try {;
                Desktop.getDesktop().browse(htmlFile.toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Check if Service-setup button was clicked. If so, open Service-setup page
        if(actionEvent.getSource() == mainMenuSetupButton){
            // Change GUI to setup gui
            frame.setContentPane(serviceSetupStartPanel);
            frame.invalidate();
            frame.validate();
        }

        // Check if quit button was clicked. If so, open main menu page
        if(actionEvent.getSource() == serviceSetupQuitToMenuButton ||
           actionEvent.getSource() == serviceSettingsQuitToMenuButton ||
           actionEvent.getSource() == testingServiceQuitButton ||
           actionEvent.getSource() == monitoringFiltersQuitButton ||
           actionEvent.getSource() == monitoringQuitButton ||
           actionEvent.getSource() == settingsQuitButton){
            // Change GUI to setup gui
            frame.setContentPane(mainMenuPanel);
            frame.invalidate();
            frame.validate();
        }

        // Check if Port has been entered, if so move on to next step
        if(actionEvent.getSource() == serviceSetupStartButton){
            // Run generateIpSettings function
            try {
                generateIpSettings();
            }
            catch (IOException e) { e.printStackTrace();
            }
            // Change GUI to next set of the setup gui
            frame.setContentPane(serviceSettingsPanel);
            frame.invalidate();
            // Update Settings text
            serviceSettingsPort.setText(servicePort);
            serviceSettingsIpGlobal.setText(globalIP);
            serviceSettingsIpLocal.setText(localIP);
            serviceSettingsIpGateway.setText(defaultGateway);
            frame.validate();
        }

        // Check if Settings clicked
        if(actionEvent.getSource() == testingServiceSettingsButton){
            System.out.println("Clicked");
            // Change GUI to next set of the setup gui
            frame.setContentPane(serviceSettingsPanel);
            frame.invalidate();
            // Update Settings text
            serviceSettingsPort.setText(servicePort);
            serviceSettingsIpGlobal.setText(globalIP);
            serviceSettingsIpLocal.setText(localIP);
            serviceSettingsIpGateway.setText(defaultGateway);
            frame.validate();
        }

        // Check if Test connection has been clicked, if so move on to test
        if(actionEvent.getSource() == serviceSettingsConfirmButton){
            if ((serviceSettingsPortTextField.getText()).length() > 0 || !servicePort.equals("No Port")) {
                // Update settings
                serviceSettingsError.setText("");
                if ((serviceSettingsIpLocalTextField.getText()).length() > 0) {
                    localIP = serviceSettingsIpLocalTextField.getText();
                    System.out.println("Setting Changed");
                }
                if ((serviceSettingsIpGlobalTextField.getText()).length() > 0) {
                    globalIP = serviceSettingsIpGlobalTextField.getText();
                    System.out.println("Setting Changed");
                }
                if ((serviceSettingsIpGatewayTextField.getText()).length() > 0) {
                    defaultGateway = serviceSettingsIpGatewayTextField.getText();
                    System.out.println("Setting Changed");
                }
                if ((serviceSettingsPortTextField.getText()).length() > 0) {
                    servicePort = serviceSettingsPortTextField.getText();
                    System.out.println("Setting Changed");
                }
                // Change GUI to setup gui
                frame.setContentPane(testingServicePanel);
                frame.invalidate();
                frame.validate();
            }
            else {
                System.out.println("Error");
                serviceSettingsError.setText("Error: No Service Port was given");
            }
        }

        // Check if Router was clicked
        if(actionEvent.getSource() == serviceSettingsRouterButton){
        //Open local gateway's router
            try {
                URI router = new URI("http://" + defaultGateway);
                java.awt.Desktop.getDesktop().browse(router);
                System.out.println("Web pages opened in browser");
            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        // Check if Test connection has been clicked, if so move on to test
        if(actionEvent.getSource() == testingServiceButton){
            System.out.println("TestStarted");
            testingServiceLine1.setText("Test Starting...(This can take up to 30 seconds)");
            testingServiceLine2.setText("");
            testingServiceLine3.setText("");
            frame.setContentPane(testingServicePanel);
            frame.invalidate();
            frame.validate();
            // Run connection test
            try {
                testConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Update GUI with test results
            if (connectionStatus) {
                testingServiceLine1.setText("Result: Connection Successful!");
            }
            else if (connectionUDP) {
                testingServiceLine1.setText("Result: Connection Possible;");
                testingServiceLine2.setText("Only If the service is using UDP and on the same port as the one entered.");
            }
            else if (connectionPing) {
                testingServiceLine1.setText("Result: Connection Failed;");
                testingServiceLine2.setText("A connection to Your service was not possible via your global IP and service port");
                testingServiceLine3.setText("Check if Port-forwarding is enabled, and the correct destination/source ports are entered, or if your local");
                testingServiceLine4.setText("machine has a firewall blocking connections to your service.");
            }
            else {
                testingServiceLine1.setText("Result: Connection Failed;");
                testingServiceLine2.setText("A connection to Your service was not possible via your global IP and service port");
                testingServiceLine3.setText("Check if Port-forwarding is enabled, and the correct destination/source ports are entered, or if your local");
                testingServiceLine4.setText("machine has a firewall blocking connections to your service.");
            }
            // After updating the GUI, set the test vars to false again, so the next test will update them correctly
            connectionPing = false;
            connectionStatus = false;
            connectionUDP = false;
        }

        // Check if Monitoring is clicked
        if(actionEvent.getSource() == mainMenuMonitorButton){
            System.out.println("Clicked");
            // Change GUI to next set of the setup gui
            frame.setContentPane(monitoringStartPanel);
            frame.invalidate();
            // Run generateIpSettings function
            try {
                generateIpSettings();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Update Settings text
            monitoringStartPort.setText(servicePort);
            monitoringStartIPAddress.setText(localIP);
            frame.validate();
        }

        // Check if Monitoring filters button is clicked
        if(actionEvent.getSource() == monitoringFiltersButton){
            System.out.println("Clicked");
            // Change GUI to next set of the setup gui
            frame.setContentPane(monitoringFiltersPanel);
            frame.invalidate();
            // See if settings were changed, if so, then update them.
            if ((monitoringStartIPAddressField.getText()).length() > 0) {
                localIP = monitoringStartIPAddressField.getText();
                System.out.println("Serv Setting Changed");
            }
            if ((monitoringStartPortField.getText()).length() > 0) {
                servicePort = monitoringStartPortField.getText();
                System.out.println("Serv Setting Changed");
            }
            // Update Settings text
            monitoringFilter1.setText("Filter for Service Port:   tcp.port==" + servicePort + "   udp.port==" + servicePort);
            monitoringFilter2.setText("Filter for Destination IP:   ip.addr==" + localIP);
            frame.validate();
        }

        // Check if Monitoring change settings button is clicked
        if(actionEvent.getSource() == monitoringChangeFilters){
            System.out.println("Changed");
            // Change GUI to next set of the setup gui
            frame.setContentPane(monitoringStartPanel);
            frame.invalidate();
            frame.validate();
        }

        // Check if Wireshark button is clicked
        if(actionEvent.getSource() == monitoringOpenWireshark){
            System.out.println("Wired");
            // Attempt to open Wireshark
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("C:\\Program Files\\Wireshark\\Wireshark.exe");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Check if Main menu settings clicked
        if(actionEvent.getSource() == mainMenuSettingsButton){
            System.out.println("Settings");
            // Change GUI to next set of the setup gui
            frame.setContentPane(settingsPanel);
            frame.invalidate();
            // Update Settings text

            frame.validate();
        }

    }

    // Function that finds Ipv4 local, global, and gateway addresses, and saves them.
    private void generateIpSettings() throws IOException {
        try {

            // cmd command
            String command = "ipconfig";
            Process cmd = Runtime.getRuntime().exec(command);

            //Read command's output
            String commandOutput;
            //String commandOutputAll = "";
            String subString;
            boolean nextLine = false;

            BufferedReader input = new BufferedReader(new InputStreamReader(cmd.getInputStream()));
            while ((commandOutput = input.readLine()) != null) {
                // commandOutputAll = commandOutputAll.concat(commandOutput) + "\n";

                if (nextLine) {
                    subString = commandOutput.substring(36);
                    System.out.println("Found a valid Gateway");
                    System.out.println(subString);
                    defaultGateway = subString.trim();
                    break;
                }

                // If the current line contains Default Gateway, then check for an IPv4 address
                if (commandOutput.contains("Default Gateway")) {
                    subString = commandOutput.substring(36);
                    if (!subString.equals("\n")) {
                        // If the current IP address is IPv6, then check the next line for IPv4
                        if (subString.contains(":")) {
                            nextLine = true;
                        }
                        else {
                            System.out.println("Found a valid Gateway");
                            System.out.println(subString);
                            defaultGateway = subString.trim();
                            break;
                        }
                    }
                }
            }
            // System.out.println(commandOutputAll);
            input.close();

            // Get Global IPv4
            URL whatIsMyIP = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    whatIsMyIP.openStream()));
            globalIP = in.readLine();
            System.out.println(globalIP);

            // Get Local IPv4
            String ip = String.valueOf(InetAddress.getLocalHost());
            int cut = ip.indexOf("/");
            localIP = ip.substring(cut + 1);
            System.out.println(localIP);

        }

        catch (Exception error) {
            error.printStackTrace();

        }
    }

    // Test connection function
    private void testConnection() throws IOException {
        try {

            // Use the PowerShell Test-NetConnection
            String powerShellCommand = ("powershell.exe Test-NetConnection " + globalIP + " -port " + servicePort);
            Process powerShellProcess = Runtime.getRuntime().exec(powerShellCommand);

            // Reading the Output
            powerShellProcess.getOutputStream().close();
            String outputLine;
            String outputFull = "";
            // System.out.println("PowerShell Output:");
            BufferedReader stdout = new BufferedReader(new InputStreamReader(
                    powerShellProcess.getInputStream()));
            while ((outputLine = stdout.readLine()) != null) {
                // System.out.println(outputLine);
                outputFull = outputFull.concat(outputLine) + "\n";
            }

            // Use Output to verify connection status
            // Check if TCP connection successes
            if (!outputFull.contains("TcpTestSucceeded : True")){
                // Open a TCP connection
                System.out.println("OPenJavaSocket");
                ServerSocket testConnection = new ServerSocket(parseInt(servicePort));
                // Start a new connection test
                Process powerShellProcess2 = Runtime.getRuntime().exec(powerShellCommand);
                // Reading the Output
                powerShellProcess2.getOutputStream().close();
                String outputLine2;
                String outputFull2 = "";
                // System.out.println("PowerShell Output:");
                BufferedReader stdout2 = new BufferedReader(new InputStreamReader(
                        powerShellProcess2.getInputStream()));
                while ((outputLine2 = stdout2.readLine()) != null) {
                    // System.out.println(outputLine);
                    outputFull2 = outputFull2.concat(outputLine2) + "\n";
                    System.out.println("SecondWhile");
                }
                System.out.println("Fin");

                // Check if TCP connection successes
                if (!outputFull2.contains("TcpTestSucceeded : True")){

                    // Display Error
                    // Test if Ping works
                    if (outputFull2.contains("PingSucceeded          : True")){
                        System.out.println("Ping Success");
                        connectionPing = true;
                    }
                    System.out.println("Error: Connection Refused");
                    System.out.println(outputFull2);
                }
                else {
                    // Connection Successful
                    connectionUDP = true;
                    System.out.println("UDP Connection Possible");
                }
                stdout2.close();
                testConnection.close();
            }
            else {
                //Connection Successful
                connectionStatus = true;
                System.out.println("Connection Successful");
            }
            stdout.close();
            System.out.println(outputFull);
        }
        catch (Exception error) {
            error.printStackTrace();

        }
    }
}