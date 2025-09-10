 # Karate Feature File Execution Guide

This guide explains how to execute Karate feature files using the Karate JAR file via the command line.

---

## ✅ Prerequisites

1. **Karate JAR File**: Download the `karate.jar` file (see below for the command).
2. **Feature File**: Ensure you have a valid Karate `.feature` file.
3. **Configuration Directory**: *(Optional)* If you use `karate-config.js`, specify its directory.

---

## 📥 Download the Karate JAR File

Use this command to download the Karate JAR from GitHub releases:

```bash
curl -L "https://github.com/karatelabs/karate/releases/download/v\${KARATE_VERSION}/\${KARATE_JAR_NAME}" -o "\${KARATE_JAR_PATH}"
```

---

## 🚀 Command Syntax

To execute all feature files:

```bash
java -Dkarate.config.dir=<config-dir> -jar <karate_jar_filepath> <feature_filedir>
```

To execute a single feature file:

```bash
java -Dkarate.config.dir=<config-dir> -jar <karate_jar_filepath> <feature_filepath>
```

### Parameters:
- `<config-dir>`: *(Optional)* Path to the config directory with `karate-config.js`
- `<karate_jar_filepath>`: Path to the downloaded Karate JAR file
- `<feature_filepath>`: Path to the `.feature` file you want to run
- `<feature_filedir>`: Path to the feature files directory

---

## 💡 Example

Assume:
- Karate JAR is located at: `Downloads/karate-1.5.1.jar`
- Feature file is at: `karate-tests/tests/store_order_post.feature`
- Config directory: `karate-tests/config`
- Feature files directory: `karate-tests/tests`

Then run the command:

```bash
java -Dkarate.config.dir=karate-tests/config -jar Downloads/karate-1.5.1.jar karate-tests/tests/store_order_post.feature
```

To execute all feature files in the karate-tests/tests folder:

```bash
java -Dkarate.config.dir=karate-tests/config -jar Downloads/karate-1.5.1.jar karate-tests/tests
```
---
## 🛠 Troubleshooting

- ❌ **Incorrect paths** — Double-check the paths to JAR and feature files
- ⚠️ **Missing `karate-config.js`** — Ensure the file exists if you're using config

---

## 📌 Notes

- Ensure your `.feature` file is syntactically correct to avoid runtime errors
- You can pass a directory of feature files instead of a single file if needed

---