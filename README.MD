DEx - Extracting data independently of file formats

Welcome to the DDEx's project page. Here you'll find more information about the API.
What is DDEx?

DDEx - Document Data Extractor - is a framework that allows other applications to transparently open and extract the content of documents, regardless of formats.

We are working to provide support for:

    OLE2 file formats
        ".doc", ".xls" and ".ppt"
    OOXML file formats
        ".docx", ".xlsx" and ".pptx"
    ODF file formats
        ".odt", ".ods" and ".odp"
    PDF

DDEx is based on the Builder Design Pattern (http://en.wikipedia.org/wiki/Builder_pattern), so it can be easily extended to support other formats
Goal, challenges and differentials

DDEx aims to decouple the content extraction process from the content processing process. To do that, DDEx needs to able to handle the document format diversity, proving access to document content independently of file formats.

DDEx uses a set of APIs (such as POI and ODFDOM) and a specific software design pattern (builder) to allow applications to use the document data into other contexts, encapsulating and performing the extraction independently of format

![Alt text](http://www.lis.ic.unicamp.br/~matheus/misc/ddexa.png)' >
