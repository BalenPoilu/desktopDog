#!/bin/bash

DISPLAY_ID=":1"
SCREEN_SIZE="1200x700"

# Nettoyage forcé des processus et des sockets
pkill -9 Xephyr 2>/dev/null
pkill -9 openbox 2>/dev/null
rm -f /tmp/.X1-lock /tmp/.X11-unix/X1

# Lancement de Xephyr
Xephyr $DISPLAY_ID -ac -br -noreset -screen $SCREEN_SIZE &
XEPHYR_PID=$!

# Attente obligatoire pour la création du socket
sleep 2

# Export vers le nouveau display
export DISPLAY=$DISPLAY_ID
unset WAYLAND_DISPLAY

# Lancement d'Openbox DANS Xephyr
openbox &
sleep 1

# Lancement du projet
chmod +x ./DesktopLoader.sh
./DesktopLoader.sh

kill $XEPHYR_PID 2>/dev/null