package com.alper.leasesoftprobe.pdfgenerator;

import com.lowagie.text.DocumentException;
import org.apache.el.stream.Stream;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.Map;

@Component
public class PDFGenerator {

    public String parseThymeleafTemplate(String templateFile, Map<String, Object> data) {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        data.keySet().forEach(key->{
            context.setVariable(key,data.get(key));
        });

        return templateEngine.process(templateFile, context);
    }

    public void generatePdfFromHtml(String html, String outFile) throws IOException, DocumentException {
        String outputFolder = System.getProperty("user.home") +  File.separator + "desktop" + File.separator + outFile;
        OutputStream outputStream = new FileOutputStream(outputFolder);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(outputStream);

        outputStream.close();
    }
}
