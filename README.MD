# DDEx Project

## Extracting data independently of file formats

DDEx - Document Data Extractor - is a framework that allows  applications to transparently open and extract the content of documents, regardless of formats.

We are working to provide support for:

* OLE2 file formats [.doc, .xls, .ppt]
* OOXML file formats [.docx, .xlsx, .pptx]
* ODF file formats [.odt, .ods, .odp]
* CSV
* PDF
* Google Docs (minimal support)

## Goal, Challenges, Differentials

DDEx is based on the [Builder Design Pattern](http://en.wikipedia.org/wiki/Builder_pattern), and can be easily extended to support other formats.
DDEx aims at decoupling the process of content extraction from the content processing, handling the diversity of file formats and providing access to the document's content independently of file formats.

DDEx manages the intersection between multiple APIs (such as [Apache POI](http://poi.apache.org/) and [ODFDOM](http://incubator.apache.org/odftoolkit/)) by offering a common interface, allowing applications to use document's content in other contexts, encapsulating and performing the extraction independently of formats.


![Alt text](http://www.lis.ic.unicamp.br/~matheus/misc/ddexa.png)


## Who is using DDEx?

DDEx is being used by other projects and is associated with academic productions, such as:

* [Project BioSpread - Integrating data from Web spreadsheets](http://purl.org/biospread/)
* [2graph - An API for abstracting graph databases](http://github.com/matheusmota/ddex)
* Paper: [_"Automatic Interpretation of Biodiversity Spreadsheets Based on the Recognition of Construction Patterns"_](http://dx.doi.org/10.5220/0004898200570068)
* Paper: [_"Extracting and Semantically Integrating Implicit Schemas from Multiple Spreadsheets"_](http://seer.lcc.ufmg.br/index.php/jidm/article/view/220)
* Paper: [_"Introducing shadows: Flexible document representation and annotation on the Web"_](http://dx.doi.org/10.1109/ICDEW.2013.6547416)