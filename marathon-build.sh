#!/bin/bash

set -e

echo "Компилирует апк"

./gradlew clean assembleAlphaDebug assembleAlphaDebugAndroidTest

echo "Создает эмуляторы"

avdmanager create avd \
 --name emulator-5554 \
 --package "system-images;android-33;google_apis;arm64-v8a" \
 --device "pixel"

 avdmanager create avd \
  --name emulator-5556 \
  --package "system-images;android-34;google_apis;arm64-v8a" \
  --device "pixel"

echo "Запускает эмулятор"
emulator -avd emulator-5554 \
 -no-snapshot \
 -wipe-data \
 -port 5554 \
 -skin 720x1280 \
 -gpu host &

emulator -avd emulator-5556 \
 -no-snapshot \
 -wipe-data \
 -port 5556 \
 -skin 720x1280 \
 -gpu host &

sleep 120

echo "Запускает марафон"
marathon --marathonfile Marathonfile

echo "Завершает работу эмулятора"
adb -s emulator-5554 emu kill
adb -s emulator-5556 emu kill
