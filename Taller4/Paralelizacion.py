import random
import multiprocessing
import time

def generar_datos(n):
    datos = []
    for _ in range(n):
        temp = random.uniform(15.0, 35.0)
        hum = random.uniform(30.0, 90.0)
        co2 = random.uniform(300.0, 1000.0)
        datos.append((temp, hum, co2))
    return datos

def calcular_indice(temp, hum, co2):
    return (temp * 0.4) + (hum * 0.3) + (co2 * 0.3)

def ejecutar_secuencial(datos):
    resultados = []
    inicio = time.time()
    for registro in datos:
        indice = calcular_indice(registro[0], registro[1], registro[2])
        resultados.append(indice)
    fin = time.time()
    return fin - inicio

def procesar_sublista(sublista):
    resultados = []
    for r in sublista:
        indice = (r[0] * 0.4) + (r[1] * 0.3) + (r[2] * 0.3)
        resultados.append(indice)
    return resultados

def ejecutar_paralelo(datos):
    n = len(datos) // 4
    sublistas = [datos[i:i + n] for i in range(0, len(datos), n)]
    
    inicio = time.time()
    with multiprocessing.Pool(processes=4) as pool:
        resultados_totales = pool.map(procesar_sublista, sublistas)
    fin = time.time()
    return fin - inicio

if __name__ == "__main__":
    NUM_REGISTROS = 1000000
    
    print("Generando datos...")
    lista_registros = generar_datos(NUM_REGISTROS)
    
    print("Ejecutando versión SECUENCIAL...")
    t_secuencial = ejecutar_secuencial(lista_registros)
    
    print("Ejecutando versión PARALELA...")
    t_paralelo = ejecutar_paralelo(lista_registros)
    
    print("-" * 30)
    print(f"RESULTADOS PARA {NUM_REGISTROS} REGISTROS:")
    print(f"Tiempo Secuencial: {t_secuencial:.4f} segundos")
    print(f"Tiempo Paralelo:   {t_paralelo:.4f} segundos")
    print("-" * 30)
    
    speedup = t_secuencial / t_paralelo
    print(f"Mejora de rendimiento (Speedup): {speedup:.2f}x")