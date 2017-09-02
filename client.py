#!/usr/bin/env python3
# -*- encoding: utf-8 -*- 

import socket
import time

HOST = "localhost"
PORT = 8080
 
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
print ("\nConectando con el puerto 8080 ...\n")
time.sleep(2)

sock.connect((HOST, PORT))

print ("Conectado con el puerto 8080\n")
time.sleep(2)

print ("Enviando: Hola\n")
time.sleep(2)
print ("Esperando respuesta...\n")
time.sleep(2)
sock.sendall("Hola\n".encode())

data = sock.recv(1024).decode()

print ("Recibido: %s " % ( data ))

time.sleep(2)
 
if ( data == "aloH\n" ):
	print ("Enviando Adiós\n")
	time.sleep(2)
	print ("Esperando respuesta...\n")
	time.sleep(2)
	sock.sendall("Adiós\n".encode())
	
	data = sock.recv(1024).decode()

	print ("Recibido: %s " % ( data ))

	time.sleep(2)
 
	if (data == "sóidA\n"):
		print ("Socket cerrado\n")
		sock.close()
