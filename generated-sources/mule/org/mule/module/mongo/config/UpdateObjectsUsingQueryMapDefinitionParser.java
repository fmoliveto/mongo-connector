
package org.mule.module.mongo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.module.mongo.processors.UpdateObjectsUsingQueryMapMessageProcessor;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser.ParseDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.BeanDefinitionParsingException;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-02-14T12:17:17-06:00", comments = "Build UNKNOWN_BUILDNUMBER")
public class UpdateObjectsUsingQueryMapDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpdateObjectsUsingQueryMapDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpdateObjectsUsingQueryMapMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [update-objects-using-query-map] within the connector [mongo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [update-objects-using-query-map] within the connector [mongo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("updateObjectsUsingQueryMap");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "collection", "collection");
        parseMapAndSetProperty(element, builder, "queryAttributes", "query-attributes", "query-attribute", new ParseDelegate<String>() {


            public String parse(Element element) {
                return element.getTextContent();
            }

        }
        );
        if (hasAttribute(element, "element-ref")) {
            if (element.getAttribute("element-ref").startsWith("#")) {
                builder.addPropertyValue("element", element.getAttribute("element-ref"));
            } else {
                builder.addPropertyValue("element", (("#[registry:"+ element.getAttribute("element-ref"))+"]"));
            }
        }
        parseProperty(builder, element, "upsert", "upsert");
        parseProperty(builder, element, "multi", "multi");
        parseProperty(builder, element, "writeConcern", "writeConcern");
        parseProperty(builder, element, "username", "username");
        parseProperty(builder, element, "password", "password");
        parseProperty(builder, element, "database", "database");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}