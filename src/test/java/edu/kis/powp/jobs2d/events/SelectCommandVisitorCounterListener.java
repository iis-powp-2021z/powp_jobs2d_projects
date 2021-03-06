package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.visitor.VisitorCounter;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class SelectCommandVisitorCounterListener implements ActionListener {
    private Logger logger = Logger.getLogger("global");
    private DriverManager driverManager;

    public SelectCommandVisitorCounterListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        logger.info("Testing visitor for driver command.");
        DriverCommand command = CommandsFeature.getDriverCommandManager().getCurrentCommand();

        if (command == null) {
            logger.info("No command loaded!");
        } else {
            VisitorCounter visitor = new VisitorCounter();
            command.accept(visitor);
            logger.info("Counter: " + visitor.getCounter());
        }
    }
}
