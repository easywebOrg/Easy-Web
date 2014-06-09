package com.easyweb.service.core;

import org.logicalcobwebs.proxool.ProxoolConstants;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Properties;

/**
 * 解析proxool xml文件
 */
public class ProxoolXmlConfigurator extends DefaultHandler {
    private String poolName;

    private String driverClass;

    private String driverUrl;

    private String user;

    private String password;

    private Properties properties = new Properties();

    private static final String PROXOOL = "proxool";

    private static final String DRIVER_PROPERTIES = "driver-properties";

    private static final String PROPERTY = "property";

    private static final String NAME = "name";

    private static final String VALUE = "value";

    private boolean insideDelegateProperties;

    private boolean insideProxool;

    private StringBuffer content = new StringBuffer();

    /**
     * @see org.xml.sax.ContentHandler#startElement
     */
    public void startElement(String uri, String lname, String qname, Attributes attributes) throws SAXException {
        content.setLength(0);

        final String elementName = getElementName(uri, lname, qname);

        if (elementName.equals(PROXOOL)) {
            if (insideProxool) {
                throw new SAXException("A <" + PROXOOL + "> element can't contain another <" + PROXOOL + "> element.");
            }
            insideProxool = true;
            properties.clear();
            driverClass = null;
            driverUrl = null;
        }

        if (insideProxool) {
            if (elementName.equals(DRIVER_PROPERTIES)) {
                insideDelegateProperties = true;
            } else if (insideDelegateProperties) {
                if (elementName.equals(PROPERTY)) {
                    setDriverProperty(attributes);
                }
            }
        }
    }

    /**
     * @see org.xml.sax.ContentHandler#characters
     */
    public void characters(char[] chars, int start, int length) throws SAXException {
        if (insideProxool) {
            content.append(chars, start, length);
        }
    }

    /**
     * @see org.xml.sax.ContentHandler#endElement
     */
    public void endElement(String uri, String lname, String qname) throws SAXException {
        final String elementName = getElementName(uri, lname, qname);

        // Are we ending a proxool configuration section?
        if (elementName.equals(PROXOOL)) {

            // Check that we have defined the minimum information
            if (driverClass == null || driverUrl == null) {
                throw new SAXException("You must define the " + ProxoolConstants.DRIVER_CLASS + " and the " + ProxoolConstants.DRIVER_URL + ".");
            }

            // Build the URL; optinally defining a name
            StringBuffer url = new StringBuffer();
            url.append("proxool");
            if (poolName != null) {
                url.append(ProxoolConstants.ALIAS_DELIMITER);
                url.append(poolName);
            }
            url.append(ProxoolConstants.URL_DELIMITER);
            url.append(driverClass);
            url.append(ProxoolConstants.URL_DELIMITER);
            url.append(driverUrl);

            // This ensures we ignore remaining XML until we come across another
            // <proxool> element.
            insideProxool = false;
        }

        if (insideProxool && !elementName.equals(PROXOOL)) {
            if (elementName.equals(DRIVER_PROPERTIES)) {
                insideDelegateProperties = false;
            } else if (!insideDelegateProperties) {
                setProxoolProperty(elementName, content.toString().trim());
            }
        }
    }

    private void setProxoolProperty(String localName, String value) {
        if (localName.equals(ProxoolConstants.ALIAS)) {
            poolName = value;
        } else if (localName.equals(ProxoolConstants.DRIVER_CLASS)) {
            driverClass = value;
        } else if (localName.equals(ProxoolConstants.DRIVER_URL)) {
            driverUrl = value;
        } else {
            properties.put(ProxoolConstants.PROPERTY_PREFIX + localName, value);
        }
    }

    private void setDriverProperty(Attributes attributes) throws SAXException {
        final String name = attributes.getValue(NAME);
        final String value = attributes.getValue(VALUE);
        if (name == null || name.length() < 1 || value == null) {
            throw new SAXException("Name or value attribute missing from property element."
                    + "Name: '" + name + "' Value: '" + value + "'.");
        }
        properties.put(name, value);

        if(ProxoolConstants.USER_PROPERTY.equalsIgnoreCase(name)) {
            user = value;
        }

        if(ProxoolConstants.PASSWORD_PROPERTY.equalsIgnoreCase(name)) {
            password = value;
        }
    }

    // If no namespace use qname, else use lname.
    private String getElementName(String uri, String lname, String qname) {
        if (uri == null || "".equals(uri)) {
            return qname;
        } else {
            return lname;
        }
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getDriverUrl() {
        return driverUrl;
    }

    public void setDriverUrl(String driverUrl) {
        this.driverUrl = driverUrl;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
