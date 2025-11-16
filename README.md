# 🧪 Lista de Verificación de Pruebas

## ✅ Pruebas Funcionales

### Autenticación Biométrica

-  [ ] La app se inicia correctamente
-  [ ] El botón de autenticación es visible
-  [ ] Al presionar el botón, aparece el prompt biométrico
-  [ ] La autenticación con huella correcta muestra mensaje de éxito
-  [ ] La autenticación con huella incorrecta muestra mensaje de error
-  [ ] Cancelar la autenticación funciona correctamente

### Manejo de Estados

-  [ ] El texto de estado cambia apropiadamente
-  [ ] Los colores de estado son correctos (verde para éxito, rojo para error)
-  [ ] Los mensajes son claros y comprensibles

### Compatibilidad de Dispositivos

-  [ ] Funciona en dispositivos con sensor de huella
-  [ ] Muestra mensaje apropiado en dispositivos sin sensor
-  [ ] Maneja correctamente dispositivos sin huellas registradas

## 🎨 Pruebas de UI/UX

### Diseño Visual

-  [ ] La paleta de colores es consistente
-  [ ] Las fuentes se cargan correctamente
-  [ ] El layout es responsive
-  [ ] Los iconos se muestran correctamente

### Experiencia de Usuario

-  [ ] Las animaciones son fluidas
-  [ ] Los mensajes de feedback son claros
-  [ ] La navegación es intuitiva
-  [ ] Los tiempos de respuesta son aceptables

## 📱 Pruebas de Dispositivo

### Diferentes Versiones de Android

-  [ ] Android 6.0 (API 23)
-  [ ] Android 8.0 (API 26)
-  [ ] Android 10 (API 29)
-  [ ] Android 12 (API 31)

### Diferentes Tamaños de Pantalla

-  [ ] Teléfonos pequeños (< 5")
-  [ ] Teléfonos medianos (5" - 6")
-  [ ] Teléfonos grandes (> 6")
-  [ ] Tablets

## 🔒 Pruebas de Seguridad

### Autenticación

-  [ ] No se almacenan datos biométricos en la app
-  [ ] Las respuestas de autenticación son manejadas seguramente
-  [ ] No hay logs sensibles en producción
