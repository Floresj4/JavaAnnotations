---
title: "Custom Java Annotations"
---

This project creates and tests a field-level annotation, @Component.  Components are
created in three varieties and based on an enumerated type used to facilitate creation.  Creation
through the ComponentFactory will dynamically load the Class resource and process/set fields which
have been annotated with @Component.

The ComboComponent class of this example annotates two member fields as @Component.  If used incorrectly
this scenario will lead to infinite depth and produce a stack exception; for example, annotating
subComponentB as a ComboComponent member in the class declaration.  This example addresses solely the annotation
processing and may not represent a legitimate business-need composition - just fiddling...