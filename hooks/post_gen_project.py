#!/usr/bin/env python3
"""Post-generation hook: moves the Spring Boot application into the correct package directory."""

import os
import shutil
import stat

group_id = "{{ cookiecutter.group_id }}"
library_name = "{{ cookiecutter.library_name }}"
main_class_name = "{{ cookiecutter.main_class_name }}"

# Build the package path from group_id + library_name
package_path = group_id.replace(".", "/") + "/" + library_name

# Source: flat file placed by Cookiecutter
src_file = os.path.join("app", "src", "main", "kotlin", f"{main_class_name}Application.kt")

# Target: proper package directory structure
target_dir = os.path.join("app", "src", "main", "kotlin", package_path, "app")
os.makedirs(target_dir, exist_ok=True)

# Move the application file into the correct package directory
if os.path.exists(src_file):
    shutil.move(src_file, os.path.join(target_dir, f"{main_class_name}Application.kt"))

# Make gradlew executable
gradlew_path = "gradlew"
if os.path.exists(gradlew_path):
    st = os.stat(gradlew_path)
    os.chmod(gradlew_path, st.st_mode | stat.S_IEXEC | stat.S_IXGRP | stat.S_IXOTH)

print(f"\nProject '{{ cookiecutter.project_name }}' generated successfully!")
print(f"  Library name : {library_name}")
print(f"  Package      : {group_id}.{library_name}.app")
print(f"  Main class   : {main_class_name}Application")
print(f"\nGet started:")
print(f"  cd {{ cookiecutter.project_slug }}")
print(f"  ./gradlew build")