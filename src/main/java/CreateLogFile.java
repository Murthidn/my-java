/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

import java.util.logging.Logger;

public class CreateLogFile{
    private static final Logger logger = Logger.getLogger(CreateLogFile.class.getName());

    public static void main(String[]args){
        FileHelper.setupLogger(logger, CreateLogFile.class.getSimpleName());
        logger.info("hi");
    }
}
