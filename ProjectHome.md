# DDEx - Extracting data independently of file formats #

Welcome to the DDEx's project page. Here you'll find more information about the API.

## What is DDEx? ##

DDEx - <b>D</b>ocument <b>D</b>ata <b>Ex</b>tractor - is a framework that allows other applications to transparently open and extract the content of documents, regardless of formats.


We are working to provide support for:
<ul>
<li>OLE2 file formats </li><ul><li>".doc", ".xls" and ".ppt"</li>   </ul>
<li>OOXML file formats</li><ul><li>".docx", ".xlsx" and ".pptx"</li></ul>
<li>ODF file formats  </li><ul><li>".odt", ".ods" and ".odp"</li>   </ul>
<li>PDF</li>
</ul>

DDEx is based on the Builder Design Pattern (http://en.wikipedia.org/wiki/Builder_pattern), so it can be easily extended to support other formats

## Goal, challenges and differentials ##

DDEx aims to decouple the content extraction process from the content processing process.
To do that, DDEx needs to able to handle the document format diversity, proving access to document content independently of file formats.

DDEx uses a set of APIs (such as [POI](http://poi.apache.org/) and [ODFDOM](http://wiki.openoffice.org/wiki/ODFDOM)) and a specific software design pattern [(builder)](.md) to allow applications to use the document data into other contexts, encapsulating and performing the extraction independently of format


<img width='420px' src='http://www.lis.ic.unicamp.br/~matheus/misc/ddexa.png' />


## Getting Started ##
See some examples on our Wiki

## Getting Envolved ##
Wanna contribute with the project? E-mail us