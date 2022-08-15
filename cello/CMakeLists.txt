cmake_minimum_required(VERSION 3.22)
project(rpg_logic_engine C)

set(CMAKE_C_STANDARD 99)

include_directories(/usr/local/include)
link_directories(/usr/local/lib)

find_library(Cello Cello)

add_executable(rpg_logic_engine main.c character.c character.h dice.c dice.h defines.h)

target_link_libraries(rpg_logic_engine Cello)