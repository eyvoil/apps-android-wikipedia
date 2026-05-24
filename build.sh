#!/bin/bash

set -e

echo "Создаёт эмулятор"

avdmanager create avd \
 --name emulator-5584 \
 --package "system-images;android-33;google_apis;arm64-v8a" \
 --device "pixel"

echo "Запускает эмулятор"
emulator -avd emulator-5584 \
 -no-snapshot \
 -wipe-data \
 -port 5584 \
 -skin 720x1280 \
 -gpu host &

echo "Ждет минуту"
sleep 60

echo "Запускает тест"
./gradlew app:connectedAlphaDebugAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=org.wikipedia.lesson28.homework.SearchArticleTests#validSearchArticle

echo "Завершает работу эмулятора"
adb -s emulator-5584 emu kill

echo "Выполняет генерацию отчёта с открытием в браузере"

allure serve app/build/allure-results