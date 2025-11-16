# 📱 Actividad 12 - 🔐 App de Autenticación Biométrica

## 📋 Descripción

Aplicación Android que implementa autenticación biométrica (huella digital) utilizando la API BiometricPrompt de Android. La aplicación permite a los usuarios autenticarse de forma segura usando su huella digital registrada en el dispositivo.

## 🎯 Objetivos de aprendizaje

-  🔐 Implementación de autenticación biométrica en Android
-  📱 Uso de la API BiometricPrompt y BiometricManager
-  🎨 Diseño de interfaces intuitivas para seguridad
-  🔍 Manejo de diferentes estados de autenticación
-  ⚡ Gestión de permisos y compatibilidad de dispositivos

## 🛠️ Tecnologías utilizadas

-  🤖 **Android SDK**: API 23+ (Android 6.0+)
-  ☕ **Lenguaje**: Java
-  🔐 **BiometricPrompt**: androidx.biometric:biometric:1.1.0
-  🎨 **Material Design**: Material Components
-  🏗️ **Arquitectura**: MVC con helper classes

## 📱 Funcionalidades

### Características principales:

-  ✅ **Autenticación biométrica**: Utiliza BiometricPrompt para capturar huella digital
-  🔍 **Verificación de compatibilidad**: Detecta automáticamente si el dispositivo soporta autenticación biométrica
-  💬 **Feedback visual**: Mensajes claros de éxito, error y estados de autenticación
-  🎨 **Diseño intuitivo**: Interfaz moderna con Material Design
-  🛡️ **Manejo de errores**: Gestión robusta de diferentes escenarios de error

### Estados de autenticación:

-  🟢 **Éxito**: Huella reconocida correctamente
-  🔴 **Fallo**: Huella no reconocida
-  ⚠️ **Error**: Problemas técnicos o de hardware
-  🚫 **Cancelado**: Usuario cancela el proceso
