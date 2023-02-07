# MemoryRepositoryDemo

Demostrate a quick and dirty means of creating a service with in-memory data.  The system automatically
allocates an H2 database and hooks it up via spring data JPA to a repository.  A DataLoader component
is defined to initialize the data. From there, all is a normal JPA repo.