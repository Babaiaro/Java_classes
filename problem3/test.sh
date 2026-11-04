#!/bin/zsh
zmodload zsh/datetime
cd "${0:A:h}"

GREEN=$'\e[32m'; RED=$'\e[31m'; BOLD=$'\e[1m'; RESET=$'\e[0m'

echo "${BOLD}Compiling Main.java ...${RESET}"
if ! javac Main.java 2> compile_errors.txt; then
  echo "${RED}${BOLD}CE - Compile Error${RESET}"
  cat compile_errors.txt
  exit 1
fi
echo "${GREEN}Compiled OK${RESET}"

passed=0; total=0
for f in input*.txt(n); do
  n=${f#input}; n=${n%.txt}
  total=$((total + 1))
  echo
  echo "${BOLD}========== Test $n ==========${RESET}"
  echo "${BOLD}Input:${RESET}"
  cat "$f"

  start=$EPOCHREALTIME
  java Main < "$f" > "output$n.txt" 2> "error$n.txt"
  code=$?
  ms=$(( (EPOCHREALTIME - start) * 1000 ))

  echo "${BOLD}Your output:${RESET}"
  cat "output$n.txt"
  echo "${BOLD}Expected:${RESET}"
  cat "expected$n.txt"

  if [[ $code -ne 0 ]]; then
    echo "${RED}${BOLD}RE - Runtime Error${RESET}"
    head -5 "error$n.txt"
  elif diff -q -b "output$n.txt" "expected$n.txt" > /dev/null; then
    echo "${GREEN}${BOLD}AC - Accepted${RESET}"
    passed=$((passed + 1))
  else
    echo "${RED}${BOLD}WA - Wrong Answer${RESET}"
  fi
  printf "Time: %.0f ms\n" $ms
done

echo
echo "${BOLD}Result: $passed / $total tests passed${RESET}"
