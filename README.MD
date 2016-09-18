# DDEx Project - Document Data Extractor

## Extracting data independently of file formats

DDEx - Document Data Extractor - is a framework that allows  applications to transparently open and extract the content of documents, regardless of formats.

We are working to provide support for:

* OLE2 file formats
** ".doc", ".xls" and ".ppt"
* OOXML file formats
** ".docx", ".xlsx" and ".pptx"
* ODF file formats
** ".odt", ".ods" and ".odp"
* CSV
* PDF

## Goal, challenges and differentials

DDEx is based on the [Builder Design Pattern](http://en.wikipedia.org/wiki/Builder_pattern), and can be easily extended to support other formats.
DDEx aims at decoupling the process of content extraction from the content processing, handling the diversity of file formats and providing access to the document's content independently of file formats.

DDEx manages the intersection between multiple APIs (such as [Apache POI](http://poi.apache.org/) and [ODFDOM](http://incubator.apache.org/odftoolkit/)) by offering a common interface, allowing applications to use document's content in other contexts, encapsulating and performing the extraction independently of formats.


![Alt text](http://www.lis.ic.unicamp.br/~matheus/misc/ddexa.png)' >
