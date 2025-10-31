package ir.ninjacoder.codesnap.Utils.dep;

class DeprecatedKey {

  public static String getCssDeprecated() {

    return """
    [
      {
        "name": "clip",
        "dep": "Deprecated. Use 'clip-path' instead."
      },
      {
        "name": "ime-mode",
        "dep": "Deprecated and non-standard. Affects input method editor."
      },
      {
        "name": "font-variant",
        "dep": "Largely deprecated in favor of 'font-variant-ligatures', 'font-variant-caps', etc."
      },
      {
        "name": "kerning",
        "dep": "Deprecated. Use 'font-kerning' instead."
      },
      {
        "name": "marker-offset",
        "dep": "Deprecated and poorly supported."
      },
      {
        "name": "scroll-snap-coordinate",
        "dep": "Deprecated in favor of 'scroll-snap-align'."
      },
      {
        "name": "scroll-snap-destination",
        "dep": "Deprecated in favor of 'scroll-snap-align'."
      },
      {
        "name": "scroll-snap-points-x",
        "dep": "Deprecated in favor of 'scroll-snap-type'."
      },
      {
        "name": "scroll-snap-points-y",
        "dep": "Deprecated in favor of 'scroll-snap-type'."
      },
      {
        "name": "text-decoration: blink",
        "dep": "The 'blink' value is deprecated and removed from standards."
      },
      {
        "name": "color-adjust",
        "dep": "Deprecated. Use 'print-color-adjust' instead."
      },
      {
        "name": "box-orient",
        "dep": "Deprecated old flexbox property. Use 'flex-direction'."
      },
      {
        "name": "box-pack",
        "dep": "Deprecated old flexbox property. Use 'justify-content'."
      },
      {
        "name": "box-align",
        "dep": "Deprecated old flexbox property. Use 'align-items'."
      },
      {
        "name": "box-flex",
        "dep": "Deprecated old flexbox property. Use 'flex-grow'."
      },
      {
        "name": "box-ordinal-group",
        "dep": "Deprecated old flexbox property. Use 'order'."
      }
  ]

    """;
  }
}
