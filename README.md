# Android-code-snap

[![](https://jitpack.io/v/HanzoDev1375/Android-code-snap.svg)](https://jitpack.io/#HanzoDev1375/Android-code-snap)

![Weekly download statistics](https://jitpack.io/v/HanzoDev1375/Android-code-snap/week.svg)
![Monthly download statistics](https://jitpack.io/v/HanzoDev1375/Android-code-snap/month.svg)

# Screenshot


<div align="center">
  <img src="https://raw.githubusercontent.com/HanzoDev1375/Android-code-snap/main/img/java.png" alt="Screenshot 1" style="width:80%; height: 50%; margin: 3px;">
 
</div>

# Supported languages

- [x] java
- [x] python
- [x] javascript
- [x] c
- [x] c++
- [x] rust
- [x] php
- [x] html
- [x] css
- [x] kotlin
- [ ] typescript
- [x] csharp


## Note

- It is currently a test program, but will become a library in the future.

## Features
- [ ] Screenshot capability in Png, jpg, webp format
- [ ] Format and screenshot
- [x] Custom theme
- [ ] Custom editor


## How to using
- adding to settings.gradle

```groovy

dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}


```

- adding to build.gradle

```groovy

dependencies {
	        implementation 'com.github.HanzoDev1375:Android-code-snap:586598c41c'
}


```

### how to use in project??
adding `xml` in your activity

```xml 

  <ir.ninjacoder.codesnap.LayoutGroup
    android:layout_height="wrap_content"
    android:layout_width="match_parent"
    android:layout_marginEnd="8dp"
    android:layout_marginStart="8dp"
    android:id="@+id/editor"
    android:layout_gravity="center" />
```

### How to Using in java

```java
  private LayoutGroup editor;
  
  editor.setType(#LangType);
  
  editor.takeScreenshot();
  
  editor.getEditor().showLineNumber(#Boolean);
  
  //set full font
  editor.getEditor().setFont(#TypeFace);
  //setEditor font 
  editor.getEditor().setTypeFaceEditor(#TypeFace);
  //setLineNumberFont
  editor.getEditor().setTypeFaceLineNumber(#TypeFace);
  //how to make custom theme? see class #ColorHelper
  editor.getEditor().setColorHelper(#ColorHelper);
  //how to select theme ?
  editor.setTheme(#ThemeManager);
   //see other method in MainActivity
  
```