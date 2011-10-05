/* Copyright (C) 2010 DirecTV. All Rights Reserved. */

/**
 * 
 */
package com.directv.serviceable.utils;

import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;

/**
 * @author Suresh
 * 
 */
public class LoggerUtils {

	public static void debugStackTrace(final Class<?> originatingClass, final Exception e, final int maxLinesToPrint) {
		Logger logger = getLogger(originatingClass);
		logger.debug("<<<<<<<<<<BEGIN EXCEPTION STACK TRACE>>>>>>>>>>");
		logger.debug(e.toString());
		StackTraceElement[] stackTrace = e.getStackTrace();
		int linesToPrint = stackTrace.length > maxLinesToPrint ? maxLinesToPrint : stackTrace.length;
		logger.debug(e.getMessage());
		for (int stackLineNo = 0; stackLineNo < linesToPrint; stackLineNo++) {
			logger.debug(stackTrace[stackLineNo]);
		}
		logger.debug("<<<<<<<<<<END EXCEPTION STACK TRACE>>>>>>>>>>");
	}

	public static void errorStackTrace(final Class<?> originatingClass, final Exception e, final int maxLinesToPrint) {
		Logger logger = getLogger(originatingClass);
		logger.error("<<<<<<<<<<BEGIN EXCEPTION STACK TRACE>>>>>>>>>>");
		logger.error(e.toString());
		StackTraceElement[] stackTrace = e.getStackTrace();
		int linesToPrint = stackTrace.length > maxLinesToPrint ? maxLinesToPrint : stackTrace.length;
		logger.error(e.getMessage());
		for (int stackLineNo = 0; stackLineNo < linesToPrint; stackLineNo++) {
			logger.error(stackTrace[stackLineNo]);
		}
		logger.error("<<<<<<<<<<END EXCEPTION STACK TRACE>>>>>>>>>>");
	}

	/**
	 * @param aClass
	 * @param message
	 */
	public static void debug(final Class<?> aClass, final String message) {
		getLogger(aClass).debug(message);
	}

	private static Logger getLogger(final Class<?> aClass) {
		return Logger.getLogger(aClass);
	}

	/**
	 * @param aClass
	 * @return
	 */
	public static boolean isDebugEnabled(final Class<?> aClass) {
		return getLogger(aClass).isDebugEnabled();
	}

	/**
	 * @param aClass
	 * @param message
	 */
	public static void error(final Class<?> aClass, final String message) {
		getLogger(aClass).error(message);
	}

	/**
	 * @param aClass
	 * @param message
	 */
	public static void warn(final Class<?> aClass, final String message) {
		getLogger(aClass).warn(message);
	}

	/**
	 * @param class1
	 * @param repositoryMessageType
	 */
	public static void debugAsXml(final Class<?> aClass, final Object object) {
		debug(aClass, new XStream().toXML(object));
	}
}
