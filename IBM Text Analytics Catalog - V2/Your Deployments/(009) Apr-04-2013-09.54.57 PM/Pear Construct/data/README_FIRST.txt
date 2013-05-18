The Where custom annotator is designed to add some positional information to existing annotations. Given a heading annotation type and a target annotation type it sets a named feature in the target with the covered text of the heading annotation for the section of document that the target is in. See Install.txt for how to use the annotator in another project (It is already installed in this project, no further configuration is needed).

Two examples are included in this project to illustrate the usage of the annotator. The Quotes.anno example document is the most straightforward and it is suggested the reader starts there to familiarise themselves with the use of the annotator. The second example References.anno shows a slightly more complex usage. A brief descriptive example is given below.

Consider an example document:

************************* Document Start **************************************

Intro
-----
result a

Body
----
result b, result c
result d

Conclusion
----------
result e

************************* Document End ****************************************


If "Intro", "Body" and "Conclusion" are heading type annotations and all the "result x" strings are target annotations with a feature named chapter then that feature will be updated with the name of the section they are in. So "result d" will include a chapter feature with a value of "Body", whereas "result e" will include a chapter feature set to "Conclusion"


