# Constants
# ==============================================================================

COLOR_BLUE=\033[0;34m
COLOR_NONE=\033[0m

# Targets
# ==============================================================================

# Help
# ======================================

help:
	@grep -E '^[0-9a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) \
		| sort \
		| awk 'BEGIN {FS = ":.*?## "}; {printf "$(COLOR_BLUE)%s|$(COLOR_NONE)%s\n", $$1, $$2}' \
		| column -t -s '|'

# Clean
# ======================================

.PHONY: clean
clean: ## Remove all artefacts
	@echo 'Cleaning application'
	@lein clean

.PHONY: clean-all
clean-all: clean ## Remove all artefacts and dependencies
	@echo 'Cleaning dependencies'

# Dependencies
# ======================================

deps: project.clj ## Install dependencies
	@lein deps

.PHONY: deps-update
deps-update: clean-all ## Update dependency versions
	@echo 'Updating dependencies'
	@lein ancient upgrade :check-clojure

# Running
# ======================================

run: deps ## Run the app
	@echo 'Running application'
	@lein run
	@echo

test: deps ## Run the tests
	@echo 'Running tests'
	@lein eftest
	@echo

check: deps ## Check the code
	@echo 'Running linter'
	@lein eastwood
	@echo

build: test check ## Build the code
	@echo 'Building artefacts'
	@lein uberjar
